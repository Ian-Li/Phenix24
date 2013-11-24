package com.phenix24.http.handler;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParamBean;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParamBean;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParamBean;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.phenix24.http.HttpException;
import com.phenix24.util.droid.NetworkUtils;
import com.phenix24.util.droid.NetworkUtils.NetworkState;

import android.content.Context;
import android.text.TextUtils;

public class DefaultHttpHandler {

    static final String DEFAULT_CHARSET_UTF8 = "UTF-8";
    static final String DEFAULT_USERAGENT = "phenix24-android";

    static final int DEFAULT_CONN_TIMEOUT = 1000 * 10;
    static final int DEFAULT_CONN_SOCKET_TIMEOUT = DEFAULT_CONN_TIMEOUT;
    static final int DEFAULT_BUFFER_SZIE = 1024 * 8;

    static final int DEFAULT_CONN_MANAGER_TIMEOUT = DEFAULT_CONN_TIMEOUT;
    static final int DEFAULT_MAX_CONNECTIONS = 8;
    static final int DEFAULT_PER_ROUTE_CONNECTIONS = DEFAULT_MAX_CONNECTIONS;

    static class DefaultRetryPolicy implements HttpRequestRetryHandler {

        private static final int RETRY_TIMES = 3;

        @Override
        public boolean retryRequest(IOException exception, int executionCount,
                HttpContext context) {
            return executionCount >= RETRY_TIMES ? false : true;
        }
    }

    protected Context context;
    protected HttpClient httpClient;

    /**
     * Construct <code>DefaultHttpHandler</code> instance.
     * 
     * @param context
     */
    public DefaultHttpHandler(Context context) {
        this.context = context;
        this.httpClient = makeHttpClient();
    }

    /**
     * Create and initialize {@link HttpClient}.Set HttpClient request retry
     * policy.The HttpClient is thread safe and present a connection pool.
     * 
     * @return HttpClient
     */
    protected HttpClient makeHttpClient() {
        HttpParams httpParams = new BasicHttpParams();

        //
        // Initialize protocol parameters.
        //
        HttpProtocolParamBean httpProtocolPB = new HttpProtocolParamBean(httpParams);
        httpProtocolPB.setVersion(HttpVersion.HTTP_1_1);
        httpProtocolPB.setHttpElementCharset(DEFAULT_CHARSET_UTF8);
        httpProtocolPB.setContentCharset(DEFAULT_CHARSET_UTF8);
        httpProtocolPB.setUserAgent(DEFAULT_USERAGENT);
        httpProtocolPB.setUseExpectContinue(false);

        //
        // Initialize connect parameters.
        //
        HttpConnectionParamBean httpConnPB = new HttpConnectionParamBean(httpParams);
        httpConnPB.setConnectionTimeout(DEFAULT_CONN_TIMEOUT);
        httpConnPB.setSoTimeout(DEFAULT_CONN_SOCKET_TIMEOUT);
        httpConnPB.setSocketBufferSize(DEFAULT_BUFFER_SZIE);
        httpConnPB.setLinger(-1);
        httpConnPB.setTcpNoDelay(true);
        httpConnPB.setStaleCheckingEnabled(false);

        //
        // Register default protocol scheme.
        //
        SchemeRegistry schemeReg = new SchemeRegistry();
        Scheme httpScheme = new Scheme("http", PlainSocketFactory.getSocketFactory(), 80);
        schemeReg.register(httpScheme);

        //
        // Initialize http connection pool manager parameters.
        //
        ConnManagerParamBean connMgrPB = new ConnManagerParamBean(httpParams);
        connMgrPB.setTimeout(DEFAULT_CONN_MANAGER_TIMEOUT);
        connMgrPB.setMaxTotalConnections(DEFAULT_MAX_CONNECTIONS);
        connMgrPB.setConnectionsPerRoute(new ConnPerRouteBean(
                DEFAULT_PER_ROUTE_CONNECTIONS));

        ClientConnectionManager clientConnMgr = new ThreadSafeClientConnManager(
                httpParams, schemeReg);

        DefaultHttpClient httpClient = new DefaultHttpClient(clientConnMgr, httpParams);

        // Set httpclient retry policy when an IOException occured.
        httpClient.setHttpRequestRetryHandler(new DefaultRetryPolicy());

        return httpClient;
    }

    /**
     * Set http head and content charset.
     * 
     * @param charset
     *            E.g"UTF-8".
     */
    public void setCharset(String charset) {
        HttpParams httpParams = httpClient.getParams();
        HttpProtocolParams.setHttpElementCharset(httpParams, charset);
        HttpProtocolParams.setContentCharset(httpParams, charset);
    }

    /**
     * Set http user agent.
     * 
     * @param userAgent
     */
    public void setUserAgent(String userAgent) {
        HttpProtocolParams.setUserAgent(httpClient.getParams(), userAgent);
    }

    /**
     * Set http connect timeout and response timeout.
     * 
     * @param connectTimeout
     *            In milliseconds.
     * @param responseTimeout
     *            In milliseconds.
     */
    public void setTimeout(int connectTimeout, int responseTimeout) {
        HttpParams httpParams = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, connectTimeout);
        HttpConnectionParams.setSoTimeout(httpParams, responseTimeout);
    }

    /**
     * Set http request buffer size.
     * 
     * @param size
     *            In bytes.
     */
    public void setBufferSize(int size) {
        HttpConnectionParams.setSocketBufferSize(httpClient.getParams(), size);
    }

    /**
     * Set timeout for obtaining usable connection from connection pool.
     * 
     * @param timeout
     *            In milliseconds.
     */
    public void setConnManagerTimeout(int timeout) {
        ConnManagerParams.setTimeout(httpClient.getParams(), timeout);
    }

    /**
     * Set {@link HttpClient} connection pool carrying ability.
     * 
     * @param maxConnections
     *            Max connections.
     * @param connectionsPerRoute
     *            Connections per route.
     */
    public void setConnections(int maxConnections, int connectionsPerRoute) {
        HttpParams params = httpClient.getParams();
        ConnManagerParams.setMaxTotalConnections(params, maxConnections);
        ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(
                connectionsPerRoute));
    }

    /**
     * Set http request retry policy when an IOException occured.
     * 
     * @param retryPolicy
     *            {@link HttpRequestRetryHandler}.
     */
    public void setHttpRequestRetryHandler(HttpRequestRetryHandler retryPolicy) {
        ((DefaultHttpClient) httpClient).setHttpRequestRetryHandler(retryPolicy);
    }

    /**
     * Set http authentication,support http basic,digest auth.
     * 
     * @param username
     *            Auth user.
     * @param password
     *            Auth user password.
     * @param host
     *            Auth host,May be set to null if credenticals are applicable to
     *            any host.
     * @param port
     *            Auth host port,May be set to negative value if credenticals
     *            are applicable to any port.
     * @param realm
     *            Auth realm,May be set to null if credenticals are applicable
     *            to any realm.
     * @param authScheme
     *            Auth type,e.g."basic","digest".
     */
    public void setHttpAuth(String username, String password, String host, int port,
            String realm, String authScheme) {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
                username, password);
        AuthScope authScope = new AuthScope(host, port, realm, authScheme);

        ((DefaultHttpClient) httpClient).getCredentialsProvider().setCredentials(
                authScope, credentials);
    }

    /**
     * Send http request and handle response.
     * 
     * @param {@link HttpClient}
     * @param httpRequest
     *            Http method,e.g.{@link HttpGet} ,{@link HttpPost},
     *            {@link HttpPut},{@link HttpDelete} etc.
     * @param contentType
     *            Http header-"Content-type".
     * @return Handled http response.
     * @throws HttpException
     * @throws IOException
     */
    protected Object request(HttpClient httpClient, HttpUriRequest httpRequest,
            String contentType) throws HttpException, IOException {
        if (!TextUtils.isEmpty(contentType)) {
            httpRequest.setHeader(new BasicHeader("Content-type", contentType));
        }

        NetworkState networkState = NetworkUtils.getNetworkState(context);
        if (networkState == NetworkState.NOTHING || networkState == NetworkState.UNKNOW) {
            throw new HttpException(HttpException.NETWORK_UNAVAILABLE);
        }

        Object handledResponse = null;
        HttpResponse response = null;
        try {
            int executionCount = 0;
            boolean isRetry = true;
            HttpRequestRetryHandler retryHandler = ((DefaultHttpClient) httpClient)
                    .getHttpRequestRetryHandler();

            HttpContext excuteContext = new BasicHttpContext();
            while (isRetry) {
                try {
                    response = httpClient.execute(httpRequest, excuteContext);
                    break;
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    throw new HttpException(e);
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                    throw new HttpException(e);
                } catch (SocketException e) {
                    e.printStackTrace();
                    throw new HttpException(e);
                } catch (IOException e) {
                    isRetry = retryHandler.retryRequest(e, ++executionCount,
                            excuteContext);
                    if (!isRetry) {
                        e.printStackTrace();
                        httpRequest.abort();
                        throw e;
                    }
                }
            }

            if (response == null) {
                throw new HttpException(HttpException.UNKNOWN, "Http response is NULL");
            }

            handledResponse = handleResponse(response);
        } finally {
            // DO NOTHING;
        }

        return handledResponse;
    }

    /**
     * Handle http response.
     * 
     * @param response
     *            See {@link HttpResponse}.
     * 
     * @return Pure {@link HttpClient} response, see {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    protected Object handleResponse(HttpResponse response) throws HttpException,
            IOException {
        return response;
    }

    /**
     * Shutdown this http connection pool and releases allocated resources. This
     * includes closing all connections, whether they are currently used or not.
     */
    public void shutdown() {
        httpClient.getConnectionManager().shutdown();
    }

    /**
     * Convert http query parameters.
     * 
     * @param params
     *            Http query parameters,key-value list.
     * @return {@link HttpClient} supported key-value list.
     */
    protected List<BasicNameValuePair> toHttpQueryParams(Map<String, String> params) {
        List<BasicNameValuePair> lparams = new ArrayList<BasicNameValuePair>();
        for (Entry<String, String> entry : params.entrySet()) {
            lparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return lparams;
    }

    /**
     * Convert http headers.
     * 
     * @param headers
     *            Http headers,key-value list.
     * @return A array contain http {@link Header}.
     */
    protected Header[] toHttpHeaders(Map<String, String> headers) {
        List<Header> lHeaders = new ArrayList<Header>();
        for (Entry<String, String> entry : headers.entrySet()) {
            BasicHeader basicHeader = new BasicHeader(entry.getKey(), entry.getValue());
            lHeaders.add(basicHeader);
        }
        return (Header[]) lHeaders.toArray();
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http query parameters,can be NULL.
     * @param headers
     *            Http headers,can be NULL.
     * @return Handled http response,see {@link #handleResponse(HttpResponse)}.
     * 
     * @throws HttpException
     * @throws IOException
     */
    public Object _get(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        if (params != null) {
            String paramsStr = URLEncodedUtils.format(toHttpQueryParams(params),
                    DEFAULT_CHARSET_UTF8);
            url = "" + url;
            url += ((url.indexOf("?") == -1) ? "?" : "&") + paramsStr;
        }

        HttpUriRequest request = new HttpGet(url);
        if (headers != null) {
            request.setHeaders(toHttpHeaders(headers));
        }

        return request(httpClient, request, null);
    }

    /**
     * Http POST method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http post parameters,can be NULL.
     * @param headers
     *            Http headers,can be NULL.
     * @return Handled http response,see {@link #handleResponse(HttpResponse)}.
     * 
     * @throws HttpException
     * @throws IOException
     */
    public Object _post(String url, Map<String, String> params,
            Map<String, String> headers) throws HttpException, IOException {
        HttpEntityEnclosingRequestBase request = new HttpPost(url);
        if (params != null) {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
                    toHttpQueryParams(params), DEFAULT_CHARSET_UTF8);
            request.setEntity(entity);
        }

        if (headers != null) {
            request.setHeaders(toHttpHeaders(headers));
        }

        return request(httpClient, request, null);
    }
}
