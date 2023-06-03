package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemChangeListener;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.jar.nerdi.R;

import java.util.ArrayList;

public class LearnQuizMode extends AppCompatActivity {
   /* AppCompatButton click;
    AppCompatButton fqbutton;
    ImageSlider imageSlider;
    Intent selectIntent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (AppCompatButton) findViewById(R.id.clickHere);
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

                } else if (i == 1) {
                    fqbutton.setText("Quiz");
                }
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectIntent = new Intent (LearnQuizMode.this, SelectDecks.class);
            }
        });*/
    }