package com.mlvolt.protienboothuser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mlvolt.protienboothuser.Model.TodayModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class Today extends Fragment {



    public Today() {
        // Required empty public constructor
    }

    TextView workout, weight, postworkout, preworkout;
    BarGraph barGraph;
    DatabaseReference databaseReference;
// ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child("u1");

        weight = view.findViewById(R.id.weight);
        workout = view.findViewById(R.id.workout);
        preworkout = view.findViewById(R.id.preworkout);
        postworkout = view.findViewById(R.id.postworkout);
        barGraph = new BarGraph();
        barGraph.setBarChart((BarChart) view.findViewById(R.id.barchart));



        ValueEventListener valueEventListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TodayModel todayModel = dataSnapshot.getValue(TodayModel.class);
                weight.setText(todayModel.getWeight());
                workout.setText(todayModel.getWorkout());
                preworkout.setText(todayModel.getPreworkout());
                postworkout.setText(todayModel.getPostworkout());
                barGraph.fun(1000, Integer.parseInt(todayModel.getYour()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseReference.addValueEventListener(valueEventListener);


        return view;
    }
}
