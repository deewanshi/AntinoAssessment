package com.example.deewanshigrover.fragmentdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

    ListView listView;
    String arr[]={"abc","def","ghi","jkl","mno","pqr","stu","vwx","yza"};


    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        listView=view.findViewById(R.id.lv1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(arrayAdapter);
        return view;
    }

}
