package com.phenix24.http;

import java.io.IOException;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public interface RetryPolicy extends HttpRequestRetryHandler {

    @Override
    public boolean retryRequest(IOException exception, int executionCount,
            HttpContext context);

}
