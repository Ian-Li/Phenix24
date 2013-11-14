package com.phenix24.http;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;

import android.content.Context;

public class PlainHttpHandler extends DefaultHttpHandler {

    public PlainHttpHandler(Context context) {
        super(context);
    }

    /**
     * Http GET method.
     * 
     * @param url
     *            Start with "http://" or "https://".
     * @return String response.
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
     * @return String response.
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
     * @return String response.
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
     * @return String response.
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
     * @return String response.
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
     * @return String response.
     * @throws HttpException
     * @throws IOException
     */
    public String POST(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        return (String) _post(url, params, headers);
    }

    @Override
    protected String handleResponse(HttpResponse response) throws HttpException,
            IOException {
        return (String) super.handleResponse(response);
    }

}
