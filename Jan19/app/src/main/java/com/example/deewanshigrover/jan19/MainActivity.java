package com.example.deewanshigrover.jan19;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView tv1;
    Button btn;
    FirebaseAuth firebaseAuth;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("user register please wait....");
        tv1=findViewById(R.id.account);
        e1=findViewById(R.id.user);
        e2=findViewById(R.id.password);
        btn=findViewById(R.id.register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userRegister();


            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Login.class));
            }

        });
    }

    private void userRegister()
    {

        String user_name=e1.getText().toString().trim();
        String user_password=e2.getText().toString().trim();

        progressDialog.show();

        if (TextUtils.isEmpty(user_name))
        {
            e1.setError("please fill user field");
        }

        else if (TextUtils.isEmpty(user_password))
        {
            e2.setError("please field password");
        }

        else
        {
            firebaseAuth.createUserWithEmailAndPassword(user_name,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        startActivity(new Intent(MainActivity.this,Home.class));
                        Toast.makeText(MainActivity.this, "user register successfully", Toast.LENGTH_SHORT).show();

                    }

                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "some error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}
