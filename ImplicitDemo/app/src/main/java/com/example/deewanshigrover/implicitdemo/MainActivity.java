package com.example.deewanshigrover.implicitdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView i;
    Button b,b2;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.iv1);
        b=findViewById(R.id.btn1);

        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        e3=findViewById(R.id.et3);
        b2=findViewById(R.id.btn2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toMail=e1.getText().toString();
                String toSubject=e2.getText().toString();
                String toMessage=e3.getText().toString();
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("html/text");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{toMail});
                intent.putExtra(Intent.EXTRA_SUBJECT,toSubject);
                intent.putExtra(Intent.EXTRA_TEXT,toMessage);

                startActivity(Intent.createChooser(intent,"EmailApp"));
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,121);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==121 && resultCode==RESULT_OK)
        {
            Bitmap bitmap= (Bitmap) data.getExtras().get("data");
            i.setImageBitmap(bitmap);
        }
    }
}
