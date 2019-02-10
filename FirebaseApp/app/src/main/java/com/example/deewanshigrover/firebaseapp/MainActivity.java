package com.example.deewanshigrover.firebaseapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1,b2;
    TextView tv;
    private ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth=FirebaseAuth.getInstance();

        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btnbtn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        tv=findViewById(R.id.tv_login);
        tv.setOnClickListener(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            registerUser();
        }

        else if(v==tv)
        {
            startActivity(new Intent(MainActivity.this,LogIn.class));
        }
        else if(v==b2)
        {
            String token= FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG,"Token: "+token);
            Toast.makeText(this,token, Toast.LENGTH_SHORT).show();
        }


    }
    public void registerUser()
    {
       String nem=e1.getText().toString().trim();
       String pwd=e2.getText().toString().trim();
       progressDialog.show();
       if(TextUtils.isEmpty(nem))   //TextUtils is a class which gets and compares the text data.
       {
           e1.setError("Username is empty");
       }
       else if(TextUtils.isEmpty(pwd))
       {
           e2.setError("Password is empty");
       }
       else
       {
           firebaseAuth.createUserWithEmailAndPassword(nem,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       progressDialog.dismiss();
                       Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       progressDialog.dismiss();
                       Toast.makeText(MainActivity.this, "Problem in registering", Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }
    }
}
