package com.example.motorbazar.Fragments.HomePackage.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.motorbazar.Fragments.HomePackage.HomeTabPackage.AllVehicles;
import com.example.motorbazar.Fragments.HomePackage.HomeTabPackage.Bikes;
import com.example.motorbazar.Fragments.HomePackage.HomeTabPackage.Cars;
import com.example.motorbazar.R;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.all_vehicles, R.string.bikes, R.string.cars};
    private final Context mContext;

    public SectionPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new AllVehicles();
        }
        else if (position == 1){
            return new Bikes();
        }
        else if (position == 2){
            return new Cars();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        //display 3 different pages.
        return 3;
    }
}
