package com.example.administrator.bottomnavigationdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/10/30.
 */

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {
    private String name;
    public MyFragment(String name){
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        TextView tv = view.findViewById(R.id.name);
        tv.setText(name);
        return view;
    }
}
