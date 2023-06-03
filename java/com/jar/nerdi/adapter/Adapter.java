package com.jar.nerdi.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//import com.jar.nerdi.category.Category1;
//import com.jar.nerdi.category.Category2;
//import com.jar.nerdi.category.Category3;
import com.jar.nerdi.category.Default;

public class Adapter extends FragmentStateAdapter {

    public Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Default();
//            case 1:
//                return new Category1();
//            case 2:
//                return new Category2();
//            case 3:
//                return new Category3();
            default:
                return new Default();

        }
    }

    @Override
    public int getItemCount() {
        return 1;//4
    }
}
