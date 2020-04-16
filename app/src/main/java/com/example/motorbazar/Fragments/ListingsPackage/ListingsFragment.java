package com.example.motorbazar.Fragments.ListingsPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.motorbazar.Fragments.HomePackage.ui.main.SectionPagerAdapter;
import com.example.motorbazar.Fragments.ListingsPackage.ui.main.ListingsSectionPagerAdapter;
import com.example.motorbazar.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class ListingsFragment extends Fragment {

    private Toolbar listings_toolbar;
    private TabLayout listings_tabs;
    private ViewPager listings_viewpager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listings_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        uiInitialize(view);

        //setting up view pager and tab lay out
        ListingsSectionPagerAdapter sectionPagerAdapter = new ListingsSectionPagerAdapter(getContext(), getChildFragmentManager());
        listings_viewpager.setAdapter(sectionPagerAdapter);
        listings_tabs.setupWithViewPager(listings_viewpager);
        listings_viewpager.setOffscreenPageLimit(3);

        //setting up tool bar
        listings_toolbar.setTitle("Listings");
        ((AppCompatActivity)getActivity()).setSupportActionBar(listings_toolbar);
    }

    public void uiInitialize(View view){
        listings_toolbar = view.findViewById(R.id.listings_toolbar);
        listings_tabs = view.findViewById(R.id.listings_tabs);
        listings_viewpager = view.findViewById(R.id.listings_viewpager);
    }
}
