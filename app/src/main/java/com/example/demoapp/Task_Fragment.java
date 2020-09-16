package com.example.demoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Task_Fragment extends Fragment {
    Button storage_permisson,thread_permisson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.task_fragment, container, false);
        //Sign_up=view.findViewById(R.id.sign_up);
        storage_permisson=view.findViewById(R.id.storage_permission);
        thread_permisson=view.findViewById(R.id.thread_permisson);

        storage_permisson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment mFragment = null;
                mFragment = new Storage_Permission();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.linearlayout, mFragment).addToBackStack("login").commit();

            }
        });
        thread_permisson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    }
