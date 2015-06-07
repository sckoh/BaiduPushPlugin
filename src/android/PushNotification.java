package com.sck.plugin.baidupush;

import android.util.Log;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class PushNotification extends CordovaPlugin {
    public static CallbackContext pushCallbackContext = null;
    private static final String LOG_TAG = PushNotification.class.getSimpleName();

    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equalsIgnoreCase("init")) {
            pushCallbackContext = callbackContext;
            super.initialize(cordova, webView);

            PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                    try {
                        PushManager.startWork(cordova.getActivity().getApplicationContext(),
                                PushConstants.LOGIN_TYPE_API_KEY,
                                args.getString(0));
                    } catch (JSONException e) {
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });
            return true;
        }
        return false;
    }
}
