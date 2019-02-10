package com.example.deewanshigrover.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> arrayList=new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rv1);

        Student s1=new Student();
        s1.setImg(R.drawable.dart);
        s1.setName("DART");
        s1.setEmail("dart@gmail.com");
        arrayList.add(s1);

        Student s2=new Student();
        s2.setImg(R.drawable.background);
        s2.setName("BACKGROUND");
        s2.setEmail("back@gmail.com");
        arrayList.add(s2);

        Student s3=new Student();
        s3.setImg(R.drawable.hit);
        s3.setName("HIT");
        s3.setEmail("HIT@gmail.com");
        arrayList.add(s3);

        Student s4=new Student();
        s4.setImg(R.drawable.targets);
        s4.setName("TARGET");
        s4.setEmail("target@gmail.com");
        arrayList.add(s4);

        Student s5=new Student();
        s5.setImg(R.drawable.gameover);
        s5.setName("gameover");
        s5.setEmail("gameover@gmail.com");
        arrayList.add(s5);

        Student s6=new Student();
        s6.setImg(R.drawable.pattern);
        s6.setName("PATTERDN");
        s6.setEmail("PT@gmail.com");
        arrayList.add(s6);

        Student s7=new Student();
        s7.setImg(R.drawable.xy);
        s7.setName("XY");
        s7.setEmail("XYZ@gmail.com");
        arrayList.add(s7);


        MyAdapter obj=new MyAdapter(this,R.layout.mycard,arrayList);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(obj);





    }
}
