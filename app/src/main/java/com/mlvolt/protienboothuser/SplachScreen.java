package com.mlvolt.protienboothuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplachScreen extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                if(current_user!=null){
                    Intent intent1 = new Intent(SplachScreen.this, MainActivity.class);
                    SplachScreen.this.startActivity(intent1);
                    SplachScreen.this.finish();

                }else{

                    Intent intent2 = new Intent(SplachScreen.this, Login.class);
                    SplachScreen.this.startActivity(intent2);
                    SplachScreen.this.finish();

                }
            }
        }, SPLASH_TIME_OUT);

    }

}
