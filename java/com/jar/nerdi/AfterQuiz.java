package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AfterQuiz extends AppCompatActivity {

    AppCompatButton restart, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_quiz);

        restart = findViewById(R.id.btn_restart);
        home = findViewById(R.id.btn_home);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AfterQuiz.this, UntimedQuiz.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (AfterQuiz.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}