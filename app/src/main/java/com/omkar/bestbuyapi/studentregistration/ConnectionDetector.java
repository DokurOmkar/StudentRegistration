package com.omkar.bestbuyapi.studentregistration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by omkardokur on 12/21/15.
 */
public class ConnectionDetector {

    private Context mContext;

    public ConnectionDetector(Context mContext) {
        this.mContext = mContext;
    }

    public boolean isConnectingtoInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager != null){
           return true;
        }
        return false;
    }
}
