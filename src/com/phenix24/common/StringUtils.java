package com.phenix24.common;

public class StringUtils {

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
}
