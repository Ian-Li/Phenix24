package com.phenix24.util.droid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

    public static enum NetworkState {
        NOTHING, MOBILE, WIFI, UNKNOW
    }

    /**
     * Get device's current network state
     * 
     * @param context
     * @return NetworkState.NOTHING : device network unavailabe.
     *         NetworkState.MOBILE : device network available and connect by
     *         mobile which is GSM,WCDMA e.g. NetworkState.WIFI : device network
     *         avaiable and connect by WIFI. NetworkState.UNKNOW : device
     *         network avaiable and connect by others except mobile and
     *         WIFI,sometimes this state is similar to NetworkState.NOTHING.
     * 
     */
    public static NetworkState getNetworkState(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        NetworkState networkState;
        if (networkInfo == null || !networkInfo.isAvailable())
            networkState = NetworkState.NOTHING;
        else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE)
            networkState = NetworkState.MOBILE;
        else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
            networkState = NetworkState.WIFI;
        else
            networkState = NetworkState.UNKNOW;

        return networkState;
    }
}
