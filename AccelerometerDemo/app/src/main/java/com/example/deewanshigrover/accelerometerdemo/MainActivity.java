package com.example.deewanshigrover.accelerometerdemo;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensor;
    long lasttime;
   // float x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        lasttime=System.currentTimeMillis();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

       if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
        getAccelerometer(event);
       }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void getAccelerometer(SensorEvent event){

        float value[]=event.values;
        float x=value[0];
        float y=value[1];
        float z=value[2];
        float acceletnSqRoot=((x*x)+(y*y)+(z*z))/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long acttime=System.currentTimeMillis();

        if(acceletnSqRoot>=2) {
            if (acttime - lasttime < 200) {
                return;
            }

            lasttime = acttime;


            Intent intent = new Intent(MainActivity.this, Second.class);
            startActivity(intent);
            Toast.makeText(this, "Next activity started", Toast.LENGTH_SHORT).show();
            Log.d("dev", " last1");
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        Log.d("dev","sensorManager.registerListener");
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
