package com.example.deewanshigrover.componentsofandroid;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AllNoti extends AppCompatActivity {
    Button btn1,btn2,btn3;
    ListView listView;
    String data[]={"abc","def","ghi","jkl","mno","pqr"};

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_noti);
        listView=findViewById(R.id.lv1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);


        btn1=findViewById(R.id.btnlogout);
        btn2=findViewById(R.id.btnstatus);
        btn3=findViewById(R.id.btnshowp);
        notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(AllNoti.this,btn3);
                popupMenu.getMenuInflater().inflate(R.menu.main_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(AllNoti.this,"Clicked on"+item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(AllNoti.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("Demo Notifiaction");
                builder.setContentText("Hello");
                Intent intent=new Intent(AllNoti.this,MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),121,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                notificationManager.notify(121,builder.build());
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AllNoti.this);
                builder.setTitle("LogOut");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(AllNoti.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Action");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        if(item.getTitle()=="Edit")
        {
            Toast.makeText(this,"Click on Edit",Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle()=="Edit")
        {
            Toast.makeText(this,"Click on Delete",Toast.LENGTH_SHORT).show();
        }
        else {
            return false;
        }


        return true;
    }
}
