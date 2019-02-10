package com.example.deewanshigrover.explicitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.etname);
        e2=findViewById(R.id.etlast);
        b1=findViewById(R.id.btnsub);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String sn=e2.getText().toString();
                Intent intent=new Intent(MainActivity.this,Second.class);
                Bundle bundle=new Bundle();
                bundle.putString("username",n);
                bundle.putString("surname",sn);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
