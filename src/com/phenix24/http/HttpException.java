package com.phenix24.http;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class HttpException extends Exception {

    private static final long serialVersionUID = 1L;

    /** Unknow exception when perform http task */
    public static final int UNKNOWN = 0x00;
    /** Network unavailable */
    public static final int NETWORK_UNAVAILABLE = 0x01;
    /** Host unavailable */
    public static final int UNKNOWN_HOST = 0x02;
    /** Socket cant be initialized */
    public static final int SOCKET = 0x03;
    /** Socket read timeout */
    public static final int SOCKET_TIMEOUT = 0x04;
    /** Http status code error */
    public static final int STATUS_CODE_ERROR = 0x05;

    private int code;

    public int getCode() {
        return code;
    }

    public HttpException() {
        super("Http exception[unknown]");
        this.code = UNKNOWN;
    }

    public HttpException(String message) {
        super(message);
        code = UNKNOWN;
    }

    public HttpException(int code) {
        super("Http exception[code:" + code + "]");
        this.code = code;
    }

    public HttpException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public HttpException(Throwable cause) {
        super(cause);
        if (cause instanceof UnknownHostException) {
            code = UNKNOWN_HOST;
        } else if (cause instanceof SocketException) {
            code = SOCKET;
        } else if (cause instanceof SocketTimeoutException) {
            code = SOCKET_TIMEOUT;
        } else if (cause instanceof HttpException) {
            code = ((HttpException) cause).getCode();
        } else {
            code = UNKNOWN;
        }
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
        if (cause instanceof UnknownHostException) {
            code = UNKNOWN_HOST;
        } else if (cause instanceof SocketException) {
            code = SOCKET;
        } else if (cause instanceof SocketTimeoutException) {
            code = SOCKET_TIMEOUT;
        } else if (cause instanceof HttpException) {
            code = ((HttpException) cause).getCode();
        } else {
            code = UNKNOWN;
        }
    }
}
