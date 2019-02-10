package com.example.deewanshigrover.cardview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DEEWANSHI GROVER on 13-01-2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Activity obj;
    int res;
    ArrayList<Student> Al=new ArrayList<>();

    public MyAdapter(Activity obj,int res,ArrayList<Student> Al)
    {
        this.obj=obj;
        this.res=res;
        this.Al=Al;
    }
    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(obj).inflate(res,parent,false);

        MyHolder myHolder=new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {

        Student m1=Al.get(position);
        holder.imageView.setImageResource(m1.getImg());
        holder.tv1.setText(m1.getName());
        holder.tv2.setText(m1.getEmail());

    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv1,tv2;
        public MyHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.iv1);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
