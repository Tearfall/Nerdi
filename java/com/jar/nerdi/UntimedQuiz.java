package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UntimedQuiz extends AppCompatActivity {

    AppCompatButton buttonA, buttonB, buttonC, buttonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_untimed_quiz);

        buttonC = findViewById(R.id.btn_c);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (UntimedQuiz.this, AfterQuiz.class);
                startActivity(intent);
            }
        });




    }
}