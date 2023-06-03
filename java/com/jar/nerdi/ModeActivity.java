package com.jar.nerdi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ModeActivity extends AppCompatActivity {
    AppCompatButton fqbutton;
    ImageSlider imageSlider;
    BottomNavigationView bottomNavigationView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNav(bottomNavigationView);
        imageSlider = (ImageSlider) findViewById(R.id.image_slider);

        fqbutton = (AppCompatButton) findViewById(R.id.flashcard_quiz_text);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.flashcard, null));
        images.add(new SlideModel(R.drawable.quiz, null));
        imageSlider.setImageList(images, ScaleTypes.FIT);

        imageSlider.setItemChangeListener(new ItemChangeListener() {
            @Override
            public void onItemChanged(int i) {
                if (i == 0) {
                    fqbutton.setText("Flashcards");
                    fqbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent (ModeActivity.this, SelectDecks.class);
                            startActivity(intent);
                        }
                    });

                } else if (i == 1) {
                    fqbutton.setText("Quiz");
                    fqbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent (ModeActivity.this, SelectDecks.class);
                            startActivity(intent);
                        }
                    });

                }
            }
        });
    }
    public void bottomNav(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setSelectedItemId(R.id.mode);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mode:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.downloads:
                        startActivity(new Intent(getApplicationContext(), DownloadActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }
}