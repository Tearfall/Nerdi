package com.jar.nerdi.selectDeckFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jar.nerdi.FlashCardSettingsActivity;
import com.jar.nerdi.R;

public class SelectDeckAll extends Fragment implements View.OnClickListener {

    CardView card1, card2, card3, card4, card5, card6, card7;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_select_deck_all, container, false);

        card1 = (CardView) v.findViewById(R.id.card1);
        card2 = (CardView) v.findViewById(R.id.card2);
        card3 = (CardView) v.findViewById(R.id.card3);
        card4 = (CardView) v.findViewById(R.id.card4);
        card5 = (CardView) v.findViewById(R.id.card5);
        card6 = (CardView) v.findViewById(R.id.card6);
        card7 = (CardView) v.findViewById(R.id.card7);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.card1:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;

            case R.id.card2:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;

            case R.id.card3:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;

            case R.id.card4:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;

            case R.id.card5:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;

            case R.id.card6:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;

            case R.id.card7:
                i = new Intent(getActivity(), FlashCardSettingsActivity.class);
                startActivity(i);
                break;
        }
    }
}