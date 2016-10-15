package com.lendmybook.dagorik.lendmybook.fragmentes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lendmybook.dagorik.lendmybook.R;

public class TwoFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton floatingActionButton;

    public TwoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        Log.i("PruebaLogOnCLick", "Holi entre al on click");

        switch (view.getId()) {

            case R.id.fab:

                Log.i("PruebaDEntrolButton!", "Holi entre al Floating");

//                Toast.makeText(getActivity(), "PUCHADO!", Toast.LENGTH_LONG).show();

//                FloatingFragment floatingFragment = FloatingFragment.newInstance();
//                FragmentTransaction trans = getFragmentManager().beginTransaction();
//
//                trans.replace(R.id.fab, floatingFragment);
//
//                trans.commit();

                break;
        }
    }

    public void showDialog(){

        FragmentManager fm = getFragmentManager();
//        FragmentManager childFragmentManager = getChildFragmentManager();
        PublicarDialogFragment dialogFragment = new PublicarDialogFragment ();
//        dialogFragment.show(fm,"hola");


    }

}
