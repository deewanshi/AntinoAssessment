package com.example.deewanshigrover.crud_db;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    TextToSpeech textToSpeech;
    int res;
    EditText en;
    String text;
    Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.et_roll);
        e2=findViewById(R.id.et_fname);
        e3=findViewById(R.id.et_lname);
        b1=findViewById(R.id.btn_read);
        b2=findViewById(R.id.btn_save);
        en=findViewById(R.id.et_data);
        bn=findViewById(R.id.btn_spc_scrn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,speech_to_text.class);
                startActivity(intent);
            }
        });
        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    res=textToSpeech.setLanguage(Locale.UK);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Not supported",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void TTS(View view)
    {
        switch (view.getId())
        {
            case R.id.bt_spk:
                if(res==TextToSpeech.LANG_MISSING_DATA || res==TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(MainActivity.this,"Not Supported",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    text=en.getText().toString();
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
            case R.id.bt_stp:
                if(textToSpeech!=null)
                {
                    textToSpeech.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
