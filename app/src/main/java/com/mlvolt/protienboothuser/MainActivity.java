package com.mlvolt.protienboothuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    View haderView;
    ImageView profileDp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.botton_navigation_view);
        navigationView = findViewById(R.id.drawer_navigation_view);
        drawerLayout = findViewById(R.id.navigation_drawer);
        haderView = navigationView.getHeaderView(0);
        profileDp = haderView.findViewById(R.id.profile_dp);

        setFragment(new Today());

        profileDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new EditProfileFragment());
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.media_navigation:
                        setFragment(new MediaFragment());
                        break;

                    case R.id.analytics_navigation:
                        setFragment(new AnalyticsFragment());
                        break;

                    case R.id.today_navigation:
                        setFragment(new Today());
                        break;


                }
                return false;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.All_Gyms_drawer_menu:
                        Intent intent6 = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent6);
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                    case R.id.User_Gym_drawer_menu:
                        setFragment(new UserGymFragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }

                return false;
            }
        });




    }





    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();

    }


}
