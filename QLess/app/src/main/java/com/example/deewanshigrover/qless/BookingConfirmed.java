package com.example.deewanshigrover.qless;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BookingConfirmed extends AppCompatActivity {
    TextView a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmed);
        a=findViewById(R.id.cancel);
        b=findViewById(R.id.homego);
        c=findViewById(R.id.book);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelBook();
            }
        });
    }
    public void cancelBook(){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Cancel");
        alertDialog.setMessage("Are you sure?");
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(BookingConfirmed.this,BookingConfirmed.class));
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BookingConfirmed.this, "Booking cancelled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookingConfirmed.this,cancel.class));
            }
        });
        alertDialog.show();
    }
}
