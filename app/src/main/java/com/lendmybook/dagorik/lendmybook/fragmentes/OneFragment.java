package com.lendmybook.dagorik.lendmybook.fragmentes;


import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lendmybook.dagorik.lendmybook.R;

import static com.facebook.FacebookSdk.getApplicationContext;

public class OneFragment extends Fragment {

    private String urlPerfil, namePerfil;

    private ImageView picturePerfil;
    private TextView name;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_one, container, false);

        picturePerfil = (ImageView) myView.findViewById(R.id.picture_profile);
        name= (TextView) myView.findViewById(R.id.tv_name_perfil);

        loadShare();
        setData();
        return myView;

    }

    public void loadShare() {

        SharedPreferences preferences = getActivity().getSharedPreferences("sesion", getApplicationContext().MODE_PRIVATE);
        urlPerfil = preferences.getString("img_perfilG", null);
        namePerfil = preferences.getString("name_face", null);

//        Log.e("FragmentPerfil", urlPerfil);
//        Log.e("FragmentName", namePerfil);



    }

    public void setData(){

        name.setText(namePerfil);
        Glide.with(getApplicationContext()).load(urlPerfil).into(picturePerfil);

    }
}
