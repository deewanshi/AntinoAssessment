package com.example.deewanshigrover.sqlcrud;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText e1,e2,e3,e4;
    Button b1,b2,b3,b4;
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.roll);
        e2=findViewById(R.id.name);
        e3=findViewById(R.id.surname);
        b1=findViewById(R.id.btn_sv);
        b2=findViewById(R.id.btn_rd);
        myDatabase=new MyDatabase(this);
        e4=findViewById(R.id.identity);
        b3=findViewById(R.id.btn_upd);
        b4=findViewById(R.id.btn_del);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletedata=myDatabase.deleteData(e4.getText().toString());
                if(deletedata>0)
                {
                    Toast.makeText(MainActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error while deleting", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updatedata=myDatabase.isUpdate(e4.getText().toString(),e1.getText().toString(),
                        e2.getText().toString(),e3.getText().toString());
                if(updatedata==true)
                {
                    Toast.makeText(MainActivity.this, "Update successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error while updating", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor data=myDatabase.getAllData();
                if(data.getCount()==0)
                {
                    showMessage("Error","No data found");
                }
                StringBuffer buffer=new StringBuffer();
                while (data.moveToNext())
                {
                    buffer.append("id is "+data.getString(0)+"\n");
                    buffer.append("Roll is "+data.getString(1)+"\n");
                    buffer.append("Name is "+data.getString(2)+"\n");
                    buffer.append("Surname is "+data.getString(3)+"\n\n");
                }
                showMessage("data",buffer.toString());
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isData= myDatabase.isInsert(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                if(isData==true){
                    Toast.makeText(MainActivity.this, "data saved successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Error in saving", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
