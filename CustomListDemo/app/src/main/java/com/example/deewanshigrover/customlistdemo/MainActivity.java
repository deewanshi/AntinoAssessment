package com.example.deewanshigrover.customlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Employee> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lv1);
        Employee e1=new Employee();
        e1.setImg(R.mipmap.ic_launcher);
        e1.setName("Deewanshi");
        e1.setEmail("deewanshi18@gmail.com");
        arrayList.add(e1);
        Employee e2=new Employee();
        e2.setImg(R.mipmap.ic_launcher);
        e2.setName("Deew");
        e2.setEmail("deewanshi18@gmail.com");
        arrayList.add(e2);
        Employee e3=new Employee();
        e3.setImg(R.mipmap.ic_launcher);
        e3.setName("anshi");
        e3.setEmail("deewanshi18@gmail.com");
        arrayList.add(e3);
        MyAdapter obj=new MyAdapter(this,R.layout.mylist,arrayList);
        listView.setAdapter(obj);

    }
}
