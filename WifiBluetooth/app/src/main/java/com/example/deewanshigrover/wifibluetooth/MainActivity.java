package com.example.deewanshigrover.wifibluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    WifiManager wifiManager;
    Switch aSwitch;
    TextView textView;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=findViewById(R.id.sch);
        textView=findViewById(R.id.tv1);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(aSwitch.isChecked())
                {
                    Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent,121);
                    textView.setText("Bluetooth on");
                }
                else
                {
                    bluetoothAdapter.disable();
                    textView.setText("Bluetooth off");
                }
            }
        });

        toggleButton=findViewById(R.id.tbtn);
        wifiManager= (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(toggleButton.isChecked())
                {
                    wifiManager.setWifiEnabled(true);
                }
                else
                {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

    }
}
