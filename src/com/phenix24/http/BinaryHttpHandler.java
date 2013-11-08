package com.phenix24.http;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;

import android.content.Context;

public class BinaryHttpHandler extends DefaultHttpHandler {

    public BinaryHttpHandler(Context context) {
        super(context);
    }

    public byte[] GET(String url) throws HttpException, IOException {
        return GET(url, null);
    }

    public byte[] GET(String url, Map<String, String> params) throws HttpException,
            IOException {
        return GET(url, params, null);
    }

    public byte[] GET(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        return (byte[]) _get(url, params, headers);
    }

    public byte[] POST(String url) throws HttpException, IOException {
        return POST(url, null);
    }

    public byte[] POST(String url, Map<String, String> params) throws HttpException,
            IOException {
        return POST(url, params, null);
    }

    public byte[] POST(String url, Map<String, String> params, Map<String, String> headers)
            throws HttpException, IOException {
        return (byte[]) _post(url, params, headers);
    }

    @Override
    protected byte[] handleResponse(HttpResponse response) throws HttpException,
            IOException {
        // TODO
        return new byte[10];
    }

}
