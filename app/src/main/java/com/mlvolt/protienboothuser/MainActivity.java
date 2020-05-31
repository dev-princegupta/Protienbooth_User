package com.mlvolt.protienboothuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

    public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.botton_navigation_view);
        setFragment(new Gym());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.gym_navigation:
                        setFragment( new Gym());
                        break;

                    case R.id.product_navigation:
                        setFragment(new Product());
                        break;
                    case R.id.today_navigation:
                        setFragment(new Today());
                        break;


                }
                return false;
            }
        });

      }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent4 = new Intent(MainActivity.this, MapsActivity.class);
            MainActivity.this.startActivity(intent4);
        }

        public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();

        }


}
