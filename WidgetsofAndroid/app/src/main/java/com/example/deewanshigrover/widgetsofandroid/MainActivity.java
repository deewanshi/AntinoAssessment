package com.example.deewanshigrover.widgetsofandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar r;
    Button b;
    SeekBar s;
    TextView t;
    AutoCompleteTextView a;
    Spinner spinner;

    String data[]={"dv","devil","devi","data","daman","done","diet","dodo","dry"};
    String country[]={"UK","USA","Canada","France","China","India","Germany","Argentina","Brazil"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.bt1);
        r=findViewById(R.id.rt1);
        s=findViewById(R.id.sk1);
        t=findViewById(R.id.tv1);
        a=findViewById(R.id.actv1);
        spinner=findViewById(R.id.sp1);

        ArrayAdapter arrayAdapter1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter1);


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        a.setThreshold(1);
        a.setAdapter(arrayAdapter);

        s.setMax(200);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                t.setText("Your progress "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rate=String.valueOf(r.getRating());
                Toast.makeText(MainActivity.this, "Your ratings "+rate+" have been reorded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
