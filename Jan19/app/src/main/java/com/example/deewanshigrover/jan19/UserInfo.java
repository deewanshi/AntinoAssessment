package com.example.deewanshigrover.jan19;

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

public class UserInfo extends AppCompatActivity {

    ListView listView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Student> Al;
    Student student;
    MyAdapter obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        listView=findViewById(R.id.lv1);
        student=new Student();
        Al=new ArrayList<>();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("User");
        obj=new MyAdapter(this,R.layout.mylist,Al);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    student=ds.getValue(Student.class);
                    Al.add(student);
                }

                listView.setAdapter(obj);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(UserInfo.this, ""+databaseError, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
