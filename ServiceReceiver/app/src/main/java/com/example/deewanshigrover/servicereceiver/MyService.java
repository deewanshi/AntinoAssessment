package com.example.deewanshigrover.servicereceiver;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by DEEWANSHI GROVER on 24-07-2018.
 */

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()  {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.song1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

         super.onStartCommand(intent, flags, startId);
         mediaPlayer.start();
        return startId; 
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

}
