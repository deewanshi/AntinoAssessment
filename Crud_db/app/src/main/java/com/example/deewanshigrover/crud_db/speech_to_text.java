package com.example.deewanshigrover.crud_db;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class speech_to_text extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT=100;
    private TextView mVoiceInputTv;
    private ImageButton mspeakBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        mVoiceInputTv=findViewById(R.id.voiceInput);
        mspeakBtn=findViewById(R.id.btnSpeak);
        mspeakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });
    }
    public void startVoiceInput()
    {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello, Howcanblabl");
        startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case REQ_CODE_SPEECH_INPUT:
                if(resultCode==RESULT_OK && null!=data)
                {
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mVoiceInputTv.setText(result.get(0));
                }
        }
    }
}
