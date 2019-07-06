package com.rajdiran.android.movies.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.common.eventbus.EventBus;

public class Common {

    private static EventBus eventBus;

    public static void registerEventBus(Object object) {

        if (eventBus == null) {
            eventBus = new EventBus();
        }

        eventBus.register(object);
    }

    public static void unregisterEventBus(Object object) {
        if (eventBus != null) {
            try {
                eventBus.unregister(object);
            } catch (Exception e) {

            }
        }
    }

    public static void postEvent(Object event) {
        if (eventBus != null) {
            eventBus.post(event);
        }
    }

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
