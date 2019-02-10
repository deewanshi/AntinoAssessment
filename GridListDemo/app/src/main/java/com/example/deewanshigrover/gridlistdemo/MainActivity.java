package com.example.deewanshigrover.gridlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView l;
    GridView g;
    String data[]={"Dv","Aaru","Aish","Vabs","Jass","Khush","Nik","Dv","Aaru","Aish","Vabs","Jass","Khush","Nik","Aaru","Aish","Vabs","Jass","Khush","Nik","Aaru","Aish","Vabs","Jass","Khush","Nik","Aaru","Aish","Vabs","Jass","Khush","Nik","Aaru","Aish","Vabs","Jass","Khush","Nik"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=findViewById(R.id.lv1);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        l.setAdapter(arrayAdapter);

        g=findViewById(R.id.gv1);
        g.setAdapter(arrayAdapter);


    }
}
