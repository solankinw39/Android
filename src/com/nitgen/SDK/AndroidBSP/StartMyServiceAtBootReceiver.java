package com.nitgen.SDK.AndroidBSP;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
   // public void onReceive(Context context, Intent intent) {
     //   if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
       //     Intent serviceIntent = new Intent("com.myapp.MySystemService");
         //   context.startService(serviceIntent);
       // }
    //}
    
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, Android_Demo.class);  
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);  
}
    
}