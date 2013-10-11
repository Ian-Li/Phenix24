package com.phenix24.util.droid;

import android.content.Context;
import android.telephony.TelephonyManager;

public class TelephoneUtils {

    /**
     * Get the unique device ID,for example,the IMEI for GSM and the MEID or ESN
     * for CDMA phones. Requires Permission: READ_PHONE_STATE
     * 
     * @param context
     * @return device ID or null if device ID is not available.
     */
    public static String getDeviceId(Context context) {
        TelephonyManager telephonyMgr = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyMgr.getDeviceId();
    }

}
