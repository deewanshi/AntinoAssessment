package com.example.deewanshigrover.jan27;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.sense);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> list=sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=0;i<list.size();i++){
            textView.append("\n"+"Sensor is "+list.get(i).getName()+"\n");
        }
    }
}
