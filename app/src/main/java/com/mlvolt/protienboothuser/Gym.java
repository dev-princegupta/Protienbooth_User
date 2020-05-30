package com.mlvolt.protienboothuser;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gym extends Fragment {


    public Gym() {
        // Required empty public constructor
    }
    TextView gymName;
    Button gymJoiningbutton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_gym, container, false);

        gymName = view.findViewById(R.id.gym_name);

        gymName.setText(MapsActivity.gym_name);

        gymJoiningbutton = view.findViewById(R.id.gym_joining_button);
        gymJoiningbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new GymJoin());

            }
        });



        return view;
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getChildFragmentManager().beginTransaction().replace(R.id.gym_joining_frame, fragment);
        fragmentTransaction.commit();

    }



}
