package com.phenix24.http.handler;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

import com.phenix24.http.HttpException;

import android.content.Context;

public class StringHttpHandler extends DefaultHttpHandler {

    public StringHttpHandler(Context context) {
        super(context);
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @return String http response.
     * @throws HttpException
     * @throws IOException
     */
    public String GET(String url) throws HttpException, IOException {
        return GET(url, null);
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http query aguments,can be NULL.
     * @return String http response.
     * @throws HttpException
     * @throws IOException
     */
    public String GET(String url, Map<String, String> params) throws HttpException,
            IOException {
        return GET(url, params, null);
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http query aguments,can be NULL.
     * @param headers
     *            Http headers,can be NULL.
     * @return String http response.
     * @throws HttpException
     * @throws IOException
     */
    public String GET(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        return (String) _get(url, params, headers);
    }

    /**
     * Http POST method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @return String http response.
     * @throws HttpException
     * @throws IOException
     */
    public String POST(String url) throws HttpException, IOException {
        return POST(url, null);
    }

    /**
     * Http POST method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http post aguments,can be NULL.
     * @return String http response.
     * @throws HttpException
     * @throws IOException
     */
    public String POST(String url, Map<String, String> params) throws HttpException,
            IOException {
        return POST(url, params, null);
    }

    /**
     * Http POST method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @param params
     *            Http post aguments,can be NULL.
     * @param headers
     *            Http headers,can be NULL.
     * @return String http response.
     * @throws HttpException
     * @throws IOException
     */
    public String POST(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        return (String) _post(url, params, headers);
    }

    /**
     * Return String http response.
     */
    @Override
    protected String handleResponse(HttpResponse response) throws HttpException,
            IOException {
        String handledResponse = null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity = null;
            HttpEntity temp = response.getEntity();
            if (temp != null) {
                entity = new BufferedHttpEntity(temp);
                handledResponse = EntityUtils.toString(entity, DEFAULT_CHARSET_UTF8);

                entity.consumeContent();
            }
        } else {
            HttpException e = new HttpException(HttpException.STATUS_CODE_ERROR,
                    "Http status code:" + statusCode);
            e.printStackTrace();
            throw e;
        }

        return handledResponse;
    }

}
