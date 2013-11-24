package com.phenix24.http.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import com.phenix24.http.HttpException;

import android.content.Context;

public class SimpleHttpHandler extends DefaultHttpHandler {

    public SimpleHttpHandler(Context context) {
        super(context);
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @return {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse GET(String url) throws HttpException, IOException {
        return GET(url, null);
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http query parameters,can be NULL.
     * @return {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse GET(String url, Map<String, String> params) throws HttpException,
            IOException {
        return GET(url, params, null);
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
     * @return {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse GET(String url, Map<String, String> params,
            Map<String, String> headers) throws HttpException, IOException {
        return (HttpResponse) _get(url, params, headers);
    }

    /**
     * Http POST method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @return {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse POST(String url) throws HttpException, IOException {
        return POST(url, null);
    }

    /**
     * Http POST method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http post parameters,can be NULL.
     * @return {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse POST(String url, Map<String, String> params)
            throws HttpException, IOException {
        return POST(url, params, null);
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
     * @return {@link HttpResponse}.
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse POST(String url, Map<String, String> params,
            Map<String, String> headers) throws HttpException, IOException {
        return (HttpResponse) _post(url, params, headers);
    }

    /**
     * Return pure {@link HttpClient} response, see {@link HttpResponse}.
     */
    @Override
    protected HttpResponse handleResponse(HttpResponse response) throws HttpException,
            IOException {
        return response;
    }

}
