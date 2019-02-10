package com.example.deewanshigrover.servicereceiver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView tv1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv1=findViewById(R.id.tv_user);
        b1=findViewById(R.id.btn_out);

        SharedPreferences sharedPreferences=getSharedPreferences("LOgin",MODE_PRIVATE);
        String user=sharedPreferences.getString("User","");
        tv1.setText("Welcome "+user);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("LOgin",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Home.this,"Logout Success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home.this,MainActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
