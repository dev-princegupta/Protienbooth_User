package com.mlvolt.protienboothuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mlvolt.protienboothuser.Model.GymModel;
import com.mlvolt.protienboothuser.Model.InventoryData;


/**
 * A simple {@link Fragment} subclass.
 */
public class Gym extends Fragment {


    public Gym() {
        // Required empty public constructor
    }
    public int flag=0;
    public  String gym;
    TextView gymName, gymJoiningFee, gymTiming, gymAbout;
    RatingBar gymRating;
    Button gymJoiningbutton;
    Button videoPlayButton;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    InventoryAdaptor inventoryAdaptor;
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
        recyclerView = view.findViewById(R.id.recycler_view);
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
        videoPlayButton.setText("Video");
        videoPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==0){
                    setVideoFragment(new GymVideoPlayerFragment());
                    flag=1;
                    videoPlayButton.setText("Image");
                }else{
                    setVideoFragment(new GymImageFragment());
                    flag=0;
                    videoPlayButton.setText("Video");
                }


            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        FirebaseRecyclerOptions<InventoryData> options = new FirebaseRecyclerOptions.Builder<InventoryData>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Gyms Inventory").child("GYM X"), InventoryData.class)
                .build();

        inventoryAdaptor = new InventoryAdaptor(options);
        recyclerView.setAdapter(inventoryAdaptor);



        return view;
    }




    @Override
    public void onStart() {
        super.onStart();
        inventoryAdaptor.startListening();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        inventoryAdaptor.stopListening();
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
