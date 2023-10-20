package com.example.assignment2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;

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
                    String sender = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();

                }
            }
        }
    }
}