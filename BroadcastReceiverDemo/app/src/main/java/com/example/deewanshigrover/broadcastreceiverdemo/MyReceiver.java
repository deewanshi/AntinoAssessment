package com.example.deewanshigrover.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by DEEWANSHI GROVER on 22-09-2018.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String status=intent.getAction();
        if (status.equals(Intent.ACTION_POWER_CONNECTED))
        {
            Toast.makeText(context, "Power is conneted", Toast.LENGTH_SHORT).show();
        }

        else if (status.equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            Toast.makeText(context, "Power is disconnetd", Toast.LENGTH_SHORT).show();
        }
    }
}
