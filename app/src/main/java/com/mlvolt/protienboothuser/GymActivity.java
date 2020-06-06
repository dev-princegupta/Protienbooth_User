package com.mlvolt.protienboothuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mlvolt.protienboothuser.Model.GymModel;
import com.mlvolt.protienboothuser.Model.InventoryData;

public class GymActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        gymName = findViewById(R.id.gym_name);
        gymJoiningFee = findViewById(R.id.gym_joining_fee);
        gymTiming = findViewById(R.id.gym_timing);
        gymAbout = findViewById(R.id.gym_about);
        gymRating = findViewById(R.id.gym_rating);
        videoPlayButton = findViewById(R.id.youtube_video_play_button);
        recyclerView = findViewById(R.id.recycler_view);
        gymJoiningbutton = findViewById(R.id.gym_joining_button);
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


        gymJoiningbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new GymJoin());

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        FirebaseRecyclerOptions<InventoryData> options = new FirebaseRecyclerOptions.Builder<InventoryData>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Gyms Inventory").child("GYM X"), InventoryData.class)
                .build();

        inventoryAdaptor = new InventoryAdaptor(options);
        recyclerView.setAdapter(inventoryAdaptor);



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
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction().replace(R.id.gym_joining_frame, fragment);
        fragmentTransaction.commit();

    }

    public void setVideoFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction().replace(R.id.image_video_container, fragment);
        fragmentTransaction.commit();
    }

}