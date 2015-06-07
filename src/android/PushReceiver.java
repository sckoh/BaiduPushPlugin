package com.sck.plugin.baidupush;


import android.content.Context;
import android.util.Log;

import com.baidu.frontia.api.FrontiaPushMessageReceiver;

import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PushReceiver extends FrontiaPushMessageReceiver {

    private static final String LOG_TAG = PushReceiver.class.getSimpleName();
    private static final String TYPE_PUSH_INIT_CLIENT = "push_init_client";

    @Override
    public void onBind(Context context, int errorCode, String appId, String userId, String channelId, String requestId) {
        Log.d(LOG_TAG, "onBind");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", TYPE_PUSH_INIT_CLIENT);
            JSONObject data = new JSONObject();
            data.put("appId", appId);
            data.put("userId", userId);
            data.put("channelId", channelId);
            jsonObject.put("data", data);
            sendPushData(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUnbind(Context context, int i, String s) {

    }

    @Override
    public void onSetTags(Context context, int i, List<String> strings, List<String> strings2, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> strings, List<String> strings2, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> strings, String s) {

    }

    @Override
    public void onMessage(Context context, String message, String customContentString) {
        Log.d(LOG_TAG, "onMessage");
        sendPushData(customContentString);
    }

    @Override
    public void onNotificationClicked(Context context, String s, String s2, String customContentString) {
        Log.d(LOG_TAG, "onNotificationClicked");
        sendPushData(customContentString);
    }

    @Override
    public void onNotificationArrived(Context context, String s, String s2, String customContentString) {
        Log.d(LOG_TAG, "onNotificationArrived");
        sendPushData(customContentString);
    }

    private void sendPushData(JSONObject jsonObject) {
        Log.d(LOG_TAG, "sendPushData: " + (jsonObject != null ? jsonObject.toString() : "null"));
        if (PushNotification.pushCallbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, jsonObject);
            result.setKeepCallback(true);
            PushNotification.pushCallbackContext.sendPluginResult(result);
        }
    }

    private void sendPushData(String customContentString) {
        JSONObject data = new JSONObject();
        try {
            if (customContentString != null && !customContentString.equals("")) {
                data = new JSONObject(customContentString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendPushData(data);
    }


}
