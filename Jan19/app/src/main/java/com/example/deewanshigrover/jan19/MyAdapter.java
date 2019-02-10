package com.example.deewanshigrover.jan19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEEWANSHI GROVER on 20-01-2019.
 */

public class MyAdapter extends BaseAdapter{

    Activity obj;
    int res;
    ArrayList<Student> arrayList=new ArrayList<>();

    public MyAdapter(Activity obj, int res, ArrayList<Student> arrayList) {
        this.obj = obj;
        this.res = res;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        View v1= LayoutInflater.from(obj).inflate(res,parent,false);
        Student student=arrayList.get(position);
        TextView name=v1.findViewById(R.id.tv_user_nem);
        TextView mobl=v1.findViewById(R.id.tv_user_mobile);
        TextView dgntn=v1.findViewById(R.id.tv_user_Desg);

        name.setText(student.getNem());
        mobl.setText(student.getMob());
        dgntn.setText(student.getDesg());
        return v1;
    }
}
