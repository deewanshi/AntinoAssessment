package com.example.deewanshigrover.servicereceiver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2,btn3;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=getSharedPreferences("LOgin",MODE_PRIVATE);
        boolean logged=sharedPreferences.getBoolean("Is Login",false);
        if(logged)
        {
            startActivity(new Intent(MainActivity.this,Home.class));
        }
        btn=findViewById(R.id.btnstart);
        btn2=findViewById(R.id.btnstop);
        btn3=findViewById(R.id.btn_log);
        e1=findViewById(R.id.ul);
        e2=findViewById(R.id.pswd);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("LOgin",MODE_PRIVATE); 
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("User",e1.getText().toString());
                editor.putString("Password",e2.getText().toString());
                editor.putBoolean("Is Login",true);
                editor.commit();
                Toast.makeText(MainActivity.this,"Data Saved",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Home.class));
            }
        });
        //btn4=findViewById(R.id.btn_out);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyService.class);

                startService(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                stopService(intent);

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); //close app
    }
}
