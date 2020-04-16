package com.example.motorbazar;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SingleVehicleMapInfo extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mapViewOfOneVehilce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_in_map_layout);

        //initialization
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapViewOfOneVehilce = googleMap;

        LatLng location = new LatLng(27.687013, 85.334085);
        mapViewOfOneVehilce.addMarker(new MarkerOptions().position(location).title("practice"));
        //mapViewOfOneVehilce.moveCamera(CameraUpdateFactory.newLatLng(location) );
        mapViewOfOneVehilce.animateCamera(CameraUpdateFactory.newLatLngZoom(location,18),null );


    }
}
