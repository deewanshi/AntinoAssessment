package com.example.deewanshigrover.someextrawidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyList extends AppCompatActivity {

    Button btngrid;
    ListView listView;
    String num[]={"abc","def","ghi","xyz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        btngrid=findViewById(R.id.btngrd);

        btngrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyList.this,MyGrid.class);
                startActivity(intent);

            }
        });
        listView=findViewById(R.id.lv1);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,num);
        listView.setAdapter(arrayAdapter);
    }
}
