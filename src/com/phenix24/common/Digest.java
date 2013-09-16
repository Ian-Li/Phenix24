package com.phenix24.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

    public static String generate(String algorithm, String message)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
        msgDigest.update(message.getBytes("UTF-8"));
        byte[] digest = msgDigest.digest();

        return StringUtils.bytesToHexStr(digest);
    }
}
