package com.example.deewanshigrover.customlistdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEEWANSHI GROVER on 20-10-2018.
 */

public class MyAdapter extends BaseAdapter {

    Activity obj;
    int res;
    ArrayList<Employee> A1=new ArrayList<>();

    public MyAdapter(Activity obj,int res,ArrayList<Employee> A1)
    {
        this.obj=obj;
        this.res=res;
        this.A1=A1;
    }
    @Override
    public int getCount() {
        return A1.size();
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
        View view= LayoutInflater.from(obj).inflate(res,parent,false);
        Employee employee=A1.get(position);
        ImageView imageView=view.findViewById(R.id.iv1);
        TextView textView=view.findViewById(R.id.tv_name);
        TextView textView1=view.findViewById(R.id.tv_id);
        imageView.setImageResource(employee.getImg());
        textView.setText(employee.getName());
        textView1.setText(employee.getEmail());
        return view;
    }
}
