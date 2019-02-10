package com.example.deewanshigrover.someextrawidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MyGrid extends AppCompatActivity {
    GridView gridView;
    String num[]={"abc","def","ghi","xyz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grid);
        gridView=findViewById(R.id.gv1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,num);
        gridView.setAdapter(arrayAdapter);
    }
}
