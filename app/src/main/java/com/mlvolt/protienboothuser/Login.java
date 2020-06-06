package com.mlvolt.protienboothuser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mlvolt.protienboothuser.Model.TodayModel;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {

    private static final int RC_SIGN_IN = 0;
    DatabaseReference databaseReference;

    List<AuthUI.IdpConfig> providers = Arrays.asList(

            new AuthUI.IdpConfig.PhoneBuilder().build()
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");


        startActivityForResult(AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build()
                ,RC_SIGN_IN);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == RC_SIGN_IN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                String currentUserPhoneNo = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
                TodayModel todayModel = new TodayModel("Empty", "Update", "No", "No", "No", "0");
                databaseReference.child(currentUserPhoneNo).setValue(todayModel);

                Intent intent3 = new Intent(Login.this, MainActivity.class);
                Login.this.startActivity(intent3);
                Login.this.finish();

                //move to next activity with carrying user data.


            } else {

                Toast.makeText(getApplicationContext(), "Signup Failed", Toast.LENGTH_LONG).show();

            }
        }
    }
}
