package com.example.deewanshigrover.widgetsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(10000);
                    Intent intent=new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                    splash.super.finish();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}
