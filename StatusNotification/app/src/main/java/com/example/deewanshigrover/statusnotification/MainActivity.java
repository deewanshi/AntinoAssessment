package com.example.deewanshigrover.statusnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        b1=findViewById(R.id.mybtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext()); //getappliaction applies to all classes
                builder.setContentTitle("Demo Notification");
                builder.setContentText("Good Evening!");
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,121,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                //pendingIntent is like start activity which keeps intent in pending mode which means unless an until action is performed it will keep on showing.

                builder.setContentIntent(pendingIntent);
                notificationManager.notify(121,builder.build());
            }
        });
    }
}
