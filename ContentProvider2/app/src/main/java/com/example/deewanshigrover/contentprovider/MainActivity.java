package com.example.deewanshigrover.contentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView t1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn1);
        t1=findViewById(R.id.tv1);
        e1=findViewById(R.id.et1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT); //get data
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE); //which type of data to get
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            if(resultCode==RESULT_OK){
                Uri contactsData=data.getData();
                Cursor cursor=managedQuery(contactsData,null,null,null,null); //Cursor reads/writes sqlite se data row wise. managedouery holds the data
                cursor.moveToFirst(); // start from first //movetolast and movetonext

                String number=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                String nem=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                t1.setText(nem+" "+number);
                e1.setText(number);
            }
        }
    }
}
