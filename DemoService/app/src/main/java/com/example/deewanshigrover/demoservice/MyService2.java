package com.example.deewanshigrover.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * Created by DEEWANSHI GROVER on 08-09-2018.
 */

public class MyService2 extends Service {

    private final IBinder iBinder=new LocalBinder();
    private final Random mGenerato=new Random();

    public class LocalBinder extends Binder
    {
        MyService2 getService()
        {
            return MyService2.this;
        }
    }
    public MyService2()
    {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public int getRandom()
    {
        return mGenerato.nextInt(200);
    }

}
