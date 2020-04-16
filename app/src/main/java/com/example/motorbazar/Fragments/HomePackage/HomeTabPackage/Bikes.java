package com.example.motorbazar.Fragments.HomePackage.HomeTabPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.Adapters.AllVehiclesAdapter;
import com.example.motorbazar.Adapters.BikesAdapter;
import com.example.motorbazar.R;

public class Bikes extends Fragment {
    RecyclerView bikes_list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bikes_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        bikes_list=(RecyclerView) view.findViewById(R.id.bikes_list);
        bikes_list.setLayoutManager(new LinearLayoutManager(getContext()));

        String [] price = {"1000000","5000000","7000000","500000"};

        bikes_list.setAdapter(new BikesAdapter(price));
    }
}

