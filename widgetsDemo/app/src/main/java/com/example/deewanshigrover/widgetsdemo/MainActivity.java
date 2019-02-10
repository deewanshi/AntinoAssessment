package com.example.deewanshigrover.widgetsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.btn1);
        Myclick myclick=new Myclick();
        b.setOnClickListener(myclick);

    }
    public void fun(View v)
    {

        Toast.makeText(this,"Data sent",Toast.LENGTH_LONG).show();
    }

    public class Myclick implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Bonjour", Toast.LENGTH_SHORT).show();
        }
    }

}
