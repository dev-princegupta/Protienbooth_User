package com.mlvolt.protienboothuser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class GymJoin extends Fragment {

    public GymJoin() {
        // Required empty public constructor
    }
    MaterialButton alreadyMember;
    MaterialButton newMember;
    MaterialButton cancle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_gym_join, container, false);

        cancle=view.findViewById(R.id.gym_join_cancel_button);
        newMember=view.findViewById(R.id.gym_new_member_button);
        alreadyMember=view.findViewById(R.id.gym_already_member_button);
        alreadyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new GymAlreadyMember());

            }
        });
        newMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new GymNewMember());

            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              setFragment(new Fragment());

            }
        });

        return view;
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().replace(R.id.gym_joining_frame, fragment);
        fragmentTransaction.commit();
    }


}
