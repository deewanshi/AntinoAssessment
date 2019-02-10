package com.example.deewanshigrover.sessionmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.edu);
        et2=findViewById(R.id.edp);
        b1=findViewById(R.id.btnlog);
        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        boolean log=sharedPreferences.getBoolean("islogin",false);
        if(log)
        {
            startActivity(new Intent(MainActivity.this,Home.class));
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nem= et1.getText().toString();
                String pwd= et2.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("username",nem);
                editor.putString("password",pwd);
                editor.putBoolean("islogin",true);
                editor.commit();
                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Home.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
