package com.example.deewanshigrover.mytute;

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
            public void run()
            {
                super.run();
                try
                {
                    Thread.sleep(1500);
                    Intent intent=new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                    splash.super.finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
