package com.example.deewanshigrover.servicereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by DEEWANSHI GROVER on 24-07-2018.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action=intent.getAction();
        if(action.equals(Intent.ACTION_POWER_CONNECTED))
        {
            Toast.makeText(context,"Connected",Toast.LENGTH_SHORT).show();
        }
       else if(action.equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            Toast.makeText(context,"Disonnected",Toast.LENGTH_SHORT).show();
        }


    }
}
