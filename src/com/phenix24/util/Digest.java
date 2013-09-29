package com.phenix24.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

    /**
     * Generate message digest.
     * 
     * @param algorithm
     *            the name of the algorithm to use,e.g."SHA-1"
     * @param message
     * @return message digest
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available
     */
    public static String generate(String algorithm, String message)
            throws NoSuchAlgorithmException {

        MessageDigest msgDigest = MessageDigest.getInstance(algorithm);
        msgDigest.update(message.getBytes());
        byte[] digest = msgDigest.digest();

        return StringUtils.bytesToHexStr(digest);
    }
}
