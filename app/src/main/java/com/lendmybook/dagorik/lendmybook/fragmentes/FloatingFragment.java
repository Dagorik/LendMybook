package com.lendmybook.dagorik.lendmybook.fragmentes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lendmybook.dagorik.lendmybook.R;

public class FloatingFragment extends Fragment {

    public FloatingFragment() {
        // Required empty public constructor
    }

    public static FloatingFragment newInstance() {
        FloatingFragment fragment = new FloatingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floating, container, false);
        return view;
    }

}
