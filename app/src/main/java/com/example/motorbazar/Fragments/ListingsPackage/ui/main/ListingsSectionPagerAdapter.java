package com.example.motorbazar.Fragments.ListingsPackage.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.motorbazar.Fragments.ListingsPackage.ListingsTabPackage.SellingLists;
import com.example.motorbazar.Fragments.ListingsPackage.ListingsTabPackage.SoldLists;
import com.example.motorbazar.Fragments.ListingsPackage.ListingsTabPackage.WishLists;
import com.example.motorbazar.R;

public class ListingsSectionPagerAdapter extends FragmentPagerAdapter {

    private static final int[] TAB_TITLES = new int[]{R.string.wishlists, R.string.sellinglists, R.string.soldlists};
    private final Context mContext;

    public ListingsSectionPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new WishLists();
        }
        else if (position == 1){
            return new SellingLists();
        }
        else if (position == 2){
            return new SoldLists();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
}
