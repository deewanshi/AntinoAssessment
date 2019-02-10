package com.example.deewanshigrover.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    ListView list;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<User> arrayList;
    User user;
    MyAdapter obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        list=findViewById(R.id.listshow);
        user=new User();
        arrayList=new ArrayList<>();
        obj=new MyAdapter(this,R.layout.userdetail,arrayList);


        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("User");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    user=ds.getValue(User.class);
                    arrayList.add(user);
                }
                list.setAdapter(obj);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(ShowData.this, ""+databaseError, Toast.LENGTH_SHORT).show();
            }

            });


        }
}
