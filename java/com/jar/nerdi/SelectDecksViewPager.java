package com.jar.nerdi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jar.nerdi.selectDeckFragment.SelectDeckAll;
import com.jar.nerdi.selectDeckFragment.SelectDeckFragment2;
import com.jar.nerdi.selectDeckFragment.SelectDeckOthers;

public class SelectDecksViewPager extends FragmentStateAdapter {
    public SelectDecksViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new SelectDeckAll();
            case 1:
                return new SelectDeckFragment2();
            case 2:
                return new SelectDeckOthers();
            default:
                return new SelectDeckAll();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
