package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReviewModeActivity extends AppCompatActivity {
    CardView rightCV,wrongCV;
    Button btnRight,btnLeft;
    ArrayList<String> front, back;
    ArrayAdapter arrayAdapter1, arrayAdapter2;
    TextView tv1, tv2;

    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_mode);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        front = new ArrayList<String>();
        front.add("A graphic that can be drawn to the screen");
        front.add("A modern image format developed by Google");
        front.add("A collection of attributes that define the look and format of a view");
        front.add("Allows style to inherent the properties of an existing style");
        front.add("Collection of attributes that define the look and format");
        front.add("What does BMP stands for?");

        back = new ArrayList<String>();
        back.add("Drawable");
        back.add("WebP");
        back.add("Style");
        back.add("Inheritance");
        back.add("Theme");
        back.add("Bitmap");


        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.card);
        SwipeFlingAdapterView swipeFlingAdapterView1 = (SwipeFlingAdapterView) findViewById(R.id.card1);

        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.front_card, R.id.frontview, front);
        arrayAdapter2 = new ArrayAdapter<String>(this,R.layout.back_card,R.id.backview, back);

        swipeFlingAdapterView.setAdapter(arrayAdapter1);
        swipeFlingAdapterView1.setAdapter(arrayAdapter2);

        wrongCV = findViewById(R.id.wrongcv);
        wrongCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipeFlingAdapterView.getTopCardListener().selectRight();
                swipeFlingAdapterView1.getTopCardListener().selectRight();
            }
        });
        rightCV = findViewById(R.id.rightcv);
        rightCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipeFlingAdapterView.getTopCardListener().selectLeft();
                swipeFlingAdapterView1.getTopCardListener().selectLeft();
            }
        });
        swipeFlingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                swipeFlingAdapterView.setVisibility(View.INVISIBLE);
                swipeFlingAdapterView1.setVisibility(View.VISIBLE);
                swipeFlingAdapterView.animate().rotationY(-180).setDuration(500).start();
                swipeFlingAdapterView1.animate().rotationY(0).setDuration(500).start();
                //Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        swipeFlingAdapterView1.setOnItemClickListener((new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                swipeFlingAdapterView.setVisibility(View.VISIBLE);
                swipeFlingAdapterView1.setVisibility(View.INVISIBLE);
                swipeFlingAdapterView.animate().rotationY(0).setDuration(500).start();
                swipeFlingAdapterView1.animate().rotationY(180).setDuration(500).start();
                //Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        }));

        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                front.remove(0);
                arrayAdapter1.notifyDataSetChanged();
            }
            @Override
            public void onLeftCardExit(Object o) {
                //Toast.makeText(MainActivity.this, "Easy!", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onRightCardExit(Object o) {
                //Toast.makeText(MainActivity.this, "Hard!", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onAdapterAboutToEmpty(int i) {
//                front.add("XML ".concat(String.valueOf(i)));
//                arrayAdapter1.notifyDataSetChanged();
//                i++;
            }
            @Override
            public void onScroll(float v) {
            }
        });
        swipeFlingAdapterView1.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                back.remove(0);
                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                //Toast.makeText(MainActivity.this, "Easy!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object o) {
                //Toast.makeText(MainActivity.this, "Hard!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
    }
}