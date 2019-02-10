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

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1;
    TextView tv;
    private ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        firebaseAuth=FirebaseAuth.getInstance();

        e1=findViewById(R.id.et_un);
        e2=findViewById(R.id.et_pd);
        b1=findViewById(R.id.btn_login);
        b1.setOnClickListener(this);
        tv=findViewById(R.id.tv_reg);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            loginuser();
        }
        else if(v==tv){
            startActivity(new Intent(LogIn.this,MainActivity.class));
        }

    }
    public void loginuser(){
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
            firebaseAuth.signInWithEmailAndPassword(nem,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        startActivity(new Intent(LogIn.this,Profile.class));
                        Toast.makeText(LogIn.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(LogIn.this, "Problem in login", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
