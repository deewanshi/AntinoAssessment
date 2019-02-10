package com.example.deewanshigrover.qless;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookingConfirmation extends AppCompatActivity {
    TextView a,b,c,d;
    Button btn;
    /*SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
        a=findViewById(R.id.name);
        b=findViewById(R.id.roll);
        c=findViewById(R.id.room);
        d=findViewById(R.id.mob);
        btn=findViewById(R.id.conf);
        /*final String nem=sharedPreferences.getString("username","");
        final String enrol=sharedPreferences.getString("rollnum","");
        final String phn=sharedPreferences.getString("mobnum","");
        final String rom=sharedPreferences.getString("roomnum","");*/
        a.setText("nem");
        b.setText("enrol");
        c.setText("rom");
        d.setText("phn");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.commit();*/
                Intent intent=new Intent(BookingConfirmation.this,BookingConfirmed.class);
                startActivity(intent);
            }
        });
    }
}
