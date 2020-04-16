package com.example.motorbazar.Fragments.HomePackage;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.motorbazar.AddingItemsPackage.AddingVehicle;
import com.example.motorbazar.Fragments.HomePackage.ui.main.SectionPagerAdapter;
import com.example.motorbazar.R;
import com.example.motorbazar.SplashScreenPackage.SplashScreen;
import com.example.motorbazar.VehicleDetails;
import com.example.motorbazar.VehiclesInMap;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }
    private ViewPager viewPager;
    private TabLayout tabs;
    private Toolbar toolbar;
    private FloatingActionButton add_item_btn;

    private int[]tabIcons = {
            R.drawable.temprorary_logo,
            R.drawable.bike,
            R.drawable.car};

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //userInterface(view);
        viewPager = view.findViewById(R.id.home_view_pager);
        tabs = view.findViewById(R.id.tabs);
        toolbar = view.findViewById(R.id.home_toolbar);
        add_item_btn = view.findViewById(R.id.add_vehicle);


        //setting up view pager and tab lay out
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(sectionPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);

        //setting up tool bar
        toolbar.setTitle("MotorBazar");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        //setUpTabIcons();
        adding_items();


    }
    private void setUpTabIcons(){
        tabs.getTabAt(0).setIcon(tabIcons[0]);
        tabs.getTabAt(1).setIcon(tabIcons[1]);
        tabs.getTabAt(2).setIcon(tabIcons[2]);
    }

    public void adding_items(){
        add_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(getContext(),AddingVehicle.class));
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu_items, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
            if (id == R.id.notification) {
                //Toast.makeText(getContext(), "notification clicked.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), VehicleDetails.class));
            }
            else if (id == R.id.settings) {
                Toast.makeText(getContext(), "settings clicked.", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.chart) {
                Toast.makeText(getContext(), "chart clicked", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.logout) {
                //Toast.makeText(getContext(), "logout clicked.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), SplashScreen.class));
            }
            else if (id == R.id.nearBy) {
                //Toast.makeText(getContext(), "nearby clicked.", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(getContext(), VehicleDetails.class));
                mapPermission();
            }
                return super.onOptionsItemSelected(item);
    }

    public void mapPermission(){
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    startActivity(new Intent(getContext(), VehiclesInMap.class));

                    return;
                }
                else{
                    Dexter.withActivity(getActivity())
                            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                            .withListener(new PermissionListener() {
                                @Override
                                public void onPermissionGranted(PermissionGrantedResponse response) {
                                    startActivity(new Intent(getContext(), VehiclesInMap.class));

                                }

                                @Override
                                public void onPermissionDenied(PermissionDeniedResponse response) {
                                    if(response.isPermanentlyDenied()){
                                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                        builder.setTitle("Permission Denied")
                                                .setMessage("Permission is Permanently denied. You need to go to setting to allow the permission.")
                                                .setNegativeButton("Cancel",null)
                                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        Intent intent = new Intent();
                                                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                                        //intent.setData(Uri.fromParts("package",getPackageName(),null));
                                                    }
                                                })
                                                .show();
                                    }
                                    else{
                                        Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                    token.continuePermissionRequest();
                                }
                            }).check();
                }
    }

}
