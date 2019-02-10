package com.example.deewanshigrover.explicitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t=findViewById(R.id.tvuser);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String abc=bundle.getString("username");
        String def=bundle.getString("surname");
        t.setText("Welcome "+abc+" "+def);
    }
}
