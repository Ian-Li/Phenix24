package com.phenix24.http;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;

import android.content.Context;

public class PlainHttpHandler extends DefaultHttpHandler {

    public PlainHttpHandler(Context context) {
        super(context);
    }

    public String GET(String url) throws HttpException, IOException {
        return GET(url, null);
    }

    public String GET(String url, Map<String, String> params) throws HttpException,
            IOException {
        return GET(url, params, null);
    }

    public String GET(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        return (String) _get(url, params, headers);
    }

    public String POST(String url) throws HttpException, IOException {
        return POST(url, null);
    }

    public String POST(String url, Map<String, String> params) throws HttpException,
            IOException {
        return POST(url, params, null);
    }

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
