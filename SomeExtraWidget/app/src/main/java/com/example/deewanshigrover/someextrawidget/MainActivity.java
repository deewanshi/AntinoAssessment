package com.example.deewanshigrover.someextrawidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3;
    RadioButton rb1,rb2;
    RatingBar ratingBar;
    Button button,btn2;
    SeekBar skbr;
    TextView tvtprg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);

        ratingBar=findViewById(R.id.rtbr);
        button=findViewById(R.id.btnrtbr);
        btn2=findViewById(R.id.btnlb);

        skbr=findViewById(R.id.skbr);
        tvtprg=findViewById(R.id.tvprg);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyList.class);
                startActivity(intent);
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cb1.isChecked())
                {
                    Toast.makeText(MainActivity.this, "cb1 is checked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "cb1 is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });


        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cb2.isChecked())
                {
                    Toast.makeText(MainActivity.this, "cb2 is checked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "cb2 is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cb3.isChecked())
                {
                    Toast.makeText(MainActivity.this, "cb3 is checked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "cb3 is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(rb1.isChecked())
                {
                    Toast.makeText(MainActivity.this, "male", Toast.LENGTH_SHORT).show();
                }

            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(rb2.isChecked())
                {
                    Toast.makeText(MainActivity.this, "female", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String rate=String.valueOf(ratingBar.getRating());
                Toast.makeText(MainActivity.this, "you gave a"+rate, Toast.LENGTH_SHORT).show();
            }
        });

        skbr.setMax(100);

        skbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvtprg.setText("progress is "+progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
