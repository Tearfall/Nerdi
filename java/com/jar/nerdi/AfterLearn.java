package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

public class AfterLearn extends AppCompatActivity {
    AppCompatButton restart, test, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_learn);

        restart = findViewById(R.id.btn_restart);
        test = findViewById(R.id.btn_test);
        home = findViewById(R.id.btn_home);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AfterLearn.this, FlashCards.class);
                startActivity(intent);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AfterLearn.this, ModeActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AfterLearn.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}