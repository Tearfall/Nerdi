package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //needs to be fix
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", true);

        if (isLoggedIn) {
            setContentView(R.layout.activity_welcome_screen);// The user has already logged in, show the activity
        } else {
            Intent intent = new Intent(WelcomeScreen.this, LoginPage.class);
            startActivity((intent));
            finish();
            // Redirect the user back to the login page or perform any other desired action
        }
        //needs to be fix

        button = findViewById(R.id.btn_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (WelcomeScreen.this, HomePage.class);
                startActivity(intent);
            }
        });

    }
}