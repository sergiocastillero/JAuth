package com.example.jauth;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreLoginScreen extends AppCompatActivity {
    // Global properties
    Intent goToRegisterScreen;
    Intent goToLoginScreen;
    Intent goToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(1000);
        setTheme(R.style.Theme_JAuth);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prelogin_screen);

        // Properties
        Button signInBtn = findViewById(R.id.signInBtn);
        Button signUpBtn = findViewById(R.id.signUpBtn);
        TextView MainActivity = findViewById(R.id.startActivityMain);

        // Creating an intent to be able to go to another screen
        //goToRegisterScreen = new Intent(this, RegisterScreen.class);
        //goToLoginScreen = new Intent(this, LoginScreen.class);
        goToMainActivity = new Intent(this, MainActivity.class);

        // If TextView MainActivity is clicked change to MainActivity screen
        MainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToMainActivity);
            }
        });
    }
}