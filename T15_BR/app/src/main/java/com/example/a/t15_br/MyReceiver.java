package com.example.a.t15_br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by a on 2017-06-22.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] msgs = null;
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        msgs = new SmsMessage[pdus.length];
        String str = "";
        for(int i=0; i<msgs.length; i++){
            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
            str += "SMS from : "+msgs[i].getOriginatingAddress();
            str += " : "+ msgs[i].getMessageBody();
        }
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}