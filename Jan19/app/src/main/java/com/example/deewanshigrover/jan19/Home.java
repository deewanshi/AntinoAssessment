package com.example.deewanshigrover.jan19;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class Home extends AppCompatActivity {

    TextView tv_nem;
    Button button;

    EditText e1,e2,e3,e4;

    FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Student student;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth=FirebaseAuth.getInstance();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("User");
        student=new Student();
        tv_nem=findViewById(R.id.welcome);
        button=findViewById(R.id.submit);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.phone);
        e3=findViewById(R.id.location);
        e4=findViewById(R.id.dgn);

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

        tv_nem.setText("welcome "  + firebaseUser.getEmail());

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        tv_nem.setText("welcome" + sharedPreferences.getString("username",""));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        getValues();
                        databaseReference.child("User0" +i).setValue(student);
                        startActivity(new Intent(Home.this,UserInfo.class));
                        Toast.makeText(Home.this, "Data submitted successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(Home.this, ""+databaseError, Toast.LENGTH_SHORT).show();

                    }
                });
                i++;

            }

        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.logout:
                Toast.makeText(this, "Logout successfull", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(this, "About app", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                Toast.makeText(this, "exit app", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void getValues()
    {
        student.setNem(e1.getText().toString());
        student.setMob(e2.getText().toString());
        student.setAds(e3.getText().toString());
        student.setDesg(e4.getText().toString());

    }
}
