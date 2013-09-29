package com.phenix24.util;

public class StringUtils {

    /**
     * A array of bytes convert to hex string.
     * 
     * @param bytes
     * @return hex string.if parameter bytes is empty,return NULL.
     */
    public static String bytesToHexStr(byte[] bytes) {
        if (bytes == null || bytes.length == 0)
            return null;

        StringBuilder sb = new StringBuilder();
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            String strTemp = Integer.toHexString(bytes[i] & 0xFF);
            if (strTemp.length() == 1) {
                strTemp = "0" + strTemp;
            }
            sb.append(strTemp);
        }
        return sb.toString().toUpperCase();
    }

    /**
     * A hex string convert to byte array.
     * 
     * @param hexStr
     * @return byte array.if parameter hexStr is empty or hexStr.length() % 2 !=
     *         0,return NULL.
     */
    public static byte[] hexStrToBytes(String hexStr) {
        if (hexStr == null || hexStr.length() == 0 || hexStr.length() % 2 != 0)
            return null;

        int len = hexStr.length();
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len - 1; i += 2) {
            String strTemp = hexStr.substring(i, i + 2);
            bytes[i / 2] = (byte) Integer.parseInt(strTemp, 16);
        }
        return bytes;
    }
}
