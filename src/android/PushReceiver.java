package com.sck.plugin.baidupush;


import android.content.Context;
import android.util.Log;

import com.baidu.frontia.api.FrontiaPushMessageReceiver;

import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PushReceiver extends FrontiaPushMessageReceiver {

    @Override
    public void onBind(Context context, int errorCode, String appid, String userId, String channelId, String requestId) {
        Log.d("push", "onBind");
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
        Log.d("push", "onMessage");
    }

    @Override
    public void onNotificationClicked(Context context, String s, String s2, String customContentString) {
        Log.d("push", "onNotificationClicked");
        sendPushInfo(customContentString);
    }

    @Override
    public void onNotificationArrived(Context context, String s, String s2, String customContentString) {
        Log.d("push", "onNotificationArrived");
        sendPushInfo(customContentString);
    }

    private void sendPushInfo(String customContentString)
    {
        JSONObject data = new JSONObject();
        Log.d("push", "sendPushInfo");
        try
        {
            Log.d("push content", "" + customContentString);
            if (customContentString != null && !customContentString.equals("")) {
                data = new JSONObject(customContentString);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        if (PushNotification.pushCallbackContext != null)
        {
            PluginResult result = new PluginResult(PluginResult.Status.OK, data);
            result.setKeepCallback(true);
            PushNotification.pushCallbackContext.sendPluginResult(result);
        }
    }


}
