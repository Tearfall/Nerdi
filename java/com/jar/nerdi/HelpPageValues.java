package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelpPageValues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page_values);

        TextView valueID = findViewById(R.id.valueID);

        String vl = getIntent().getStringExtra("value");
        valueID.setText(vl);
    }
}