package com.example.myapplication.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.Views.Fragments.ContactUs;
import com.example.myapplication.Views.Fragments.Home;
import com.example.myapplication.Views.Fragments.WhereAreWe;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0: return new WhereAreWe();
           case 1: return new Home();
           case 2: return new ContactUs();
           default: return new Home();
       }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
