package com.mlvolt.protienboothuser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class GymNewMember extends Fragment {

    public GymNewMember() {
        // Required empty public constructor
    }
    MaterialButton submit;
    MaterialButton cancel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gym_new_member, container, false);
        cancel = view.findViewById(R.id.gym_new_member_cancel_button);
        submit = view.findViewById(R.id.gym_new_member_submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getContext(),"Your request For Gym Membership is syccessfull, admin will varify you soon",Toast.LENGTH_LONG);
                toast.show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new Fragment());
            }
        });


        return view;
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction().replace(R.id.gym_joining_frame, fragment);
        fragmentTransaction.commit();
    }


}
