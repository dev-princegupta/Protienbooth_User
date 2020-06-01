package com.mlvolt.protienboothuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mlvolt.protienboothuser.Model.GymModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gym extends Fragment {


    public Gym() {
        // Required empty public constructor
    }
    public  String gym;
    TextView gymName, gymJoiningFee, gymTiming, gymAbout;
    RatingBar gymRating;
    Button gymJoiningbutton;
    Button videoPlayButton;
    DatabaseReference databaseReference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_gym, container, false);

        gymName = view.findViewById(R.id.gym_name);
        gymJoiningFee = view.findViewById(R.id.gym_joining_fee);
        gymTiming = view.findViewById(R.id.gym_timing);
        gymAbout = view.findViewById(R.id.gym_about);
        gymRating = view.findViewById(R.id.gym_rating);
        videoPlayButton = view.findViewById(R.id.youtube_video_play_button);
        gymRating.setEnabled(true);

        gym = MapsActivity.gym_name;
        gymName.setText(MapsActivity.gym_name);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gyms Data");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GymModel gymModel = dataSnapshot.child(gym).getValue(GymModel.class);

                gymJoiningFee.setText(gymModel.getPrice());
                gymTiming.setText(gymModel.getTiming());
                gymAbout.setText(gymModel.getAbout());
                gymRating.setRating(Float.parseFloat(gymModel.getRating()));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        gymJoiningbutton = view.findViewById(R.id.gym_joining_button);
        gymJoiningbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new GymJoin());

            }
        });

        setVideoFragment(new GymImageFragment());

        videoPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVideoFragment(new GymVideoPlayerFragment());
            }
        });





        return view;
    }


    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getChildFragmentManager().beginTransaction().replace(R.id.gym_joining_frame, fragment);
        fragmentTransaction.commit();

    }

    public void setVideoFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction  = getChildFragmentManager().beginTransaction().replace(R.id.image_video_container, fragment);
        fragmentTransaction.commit();
    }





}
