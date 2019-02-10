package com.example.deewanshigrover.filehandling;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1;
    public static final String FILE_NAME="myfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edt);
        b1=findViewById(R.id.rd);
        b2=findViewById(R.id.wrd);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=e1.getText().toString();
                FileOutputStream fout= null;
                try {
                    fout = openFileOutput(FILE_NAME, MODE_APPEND);
                    fout.write(data.getBytes());
                    fout.close();
                    e1.setText("");
                    Toast.makeText(MainActivity.this,"Data saved",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {

                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin=openFileInput(FILE_NAME);
                    int x=0;
                    String data="";
                    while((x=fin.read())!=-1)
                    {
                        data=data + Character.toString((char)x);
                    }
                    Toast.makeText(MainActivity.this, ""+data, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {

                }

            }
        });
    }
}
