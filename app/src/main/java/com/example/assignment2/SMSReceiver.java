package com.example.assignment2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.InputFilter;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        final Bundle bundle = intent.getExtras();
        if(intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){

            if(bundle != null ){
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                String format = bundle.getString("format").toString();

                for(int i = 0; i < pdusObj.length; i++){
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                    String message = currentMessage.getDisplayMessageBody();
                    String printMessage = message + " has been added";
                    Log.i("SMS", printMessage);

                    Intent activityIntent = new Intent(context, MainActivity.class);
                    activityIntent.putExtra("sms", message);
                    activityIntent.setAction(Intent.ACTION_SEND);
                    activityIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(activityIntent);
                }
            }
        }
    }
}