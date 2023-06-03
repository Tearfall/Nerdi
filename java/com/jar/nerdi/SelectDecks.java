package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class SelectDecks extends AppCompatActivity {

    CardView card1;
    TabLayout selectDecksTabLayout;
    ViewPager2 selectDecksViewPager2;
    SelectDecksViewPager selectDecksVPAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_decks);

        selectDecksTabLayout = findViewById(R.id.tabSelect);
        selectDecksViewPager2 = findViewById(R.id.viewpagerSelect);
        selectDecksVPAdapter = new SelectDecksViewPager(this);
        selectDecksViewPager2.setAdapter(selectDecksVPAdapter);

        selectDecksTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectDecksViewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        selectDecksViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                selectDecksTabLayout.getTabAt(position).select();
            }
        });

    }
}