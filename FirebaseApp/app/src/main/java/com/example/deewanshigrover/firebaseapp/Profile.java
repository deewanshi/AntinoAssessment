package com.example.deewanshigrover.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    TextView tv;
    Button btn,btn1;
    EditText e1,e2,e3,e4,e5;
    FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tv=findViewById(R.id.tv_user);
        btn=findViewById(R.id.btn_out);
        e1=findViewById(R.id.et_name);
        e2=findViewById(R.id.et_mail);
        e3=findViewById(R.id.et_num);
        e4=findViewById(R.id.et_pname);
        e5=findViewById(R.id.et_techname);
        btn1=findViewById(R.id.btn_sav);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        getValues();
                        databaseReference.child("User01").setValue(user);
                        startActivity(new Intent(Profile.this,ShowData.class));
                        Toast.makeText(Profile.this, "Data Submitted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(Profile.this, ""+databaseError, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("User");
        user=new User();

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        tv.setText("Welcome "+firebaseUser.getEmail());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(Profile.this,LogIn.class));
                Toast.makeText(Profile.this, "Logout successfull", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getValues(){
        user.setNem(e1.getText().toString());
        user.setEmail(e2.getText().toString());
        user.setPhn(e3.getText().toString());
        user.setProj(e4.getText().toString());
        user.setTech(e5.getText().toString());
    }
}
