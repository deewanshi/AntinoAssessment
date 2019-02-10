package com.example.deewanshigrover.firebaseapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEEWANSHI GROVER on 03-11-2018.
 */

public class MyAdapter extends BaseAdapter {

    Activity obj;
    int res;
    ArrayList<User> Al= new ArrayList<>();

    public MyAdapter(Activity obj, int res, ArrayList<User> Al) {

        this.obj = obj;
        this.res = res;
        this.Al = Al;
    }
        @Override
    public int getCount() {
        return Al.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view1= LayoutInflater.from(obj).inflate(res,parent,false);
        User user=Al.get(position);
        TextView textView1=view1.findViewById(R.id.tv_nem);
        TextView textView2=view1.findViewById(R.id.tv_email);
        textView1.setText(user.getNem());
        textView2.setText(user.getEmail());
        return view1;
    }
}
