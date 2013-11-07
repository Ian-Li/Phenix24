package com.phenix24.http;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class HttpException extends Exception {

    private static final long serialVersionUID = 1L;

    //
    // Exception type
    //
    public static final int UNKNOWN = 0;
    public static final int NETWORK_UNAVAILABLE = 1;
    public static final int UNKNOWN_HOST = 2;
    public static final int SOCKET = 3;
    public static final int SOCKET_TIMEOUT = 4;
    public static final int IO = 5;

    private int code;

    public HttpException() {
        super();
        this.code = UNKNOWN;
    }

    public HttpException(int code) {
        super("HTTP Exception[Code:" + code + "]");
        this.code = code;
    }

    public HttpException(String message) {
        super(message);
        code = UNKNOWN;
    }

    public HttpException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public HttpException(Throwable cause) {
        super(cause);
        if (cause instanceof UnknownHostException) {
            code = UNKNOWN_HOST;
        } else if (cause instanceof SocketTimeoutException) {
            code = SOCKET_TIMEOUT;
        } else if (cause instanceof SocketException) {
            code = SOCKET;
        } else if (cause instanceof IOException) {
            code = IO;
        } else {
            code = UNKNOWN;
        }
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof UnknownHostException) {
            code = UNKNOWN_HOST;
        } else if (cause instanceof SocketTimeoutException) {
            code = SOCKET_TIMEOUT;
        } else if (cause instanceof SocketException) {
            code = SOCKET;
        } else if (cause instanceof IOException) {
            code = IO;
        } else {
            code = UNKNOWN;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
