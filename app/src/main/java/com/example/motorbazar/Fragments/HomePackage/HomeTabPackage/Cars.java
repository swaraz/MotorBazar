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

import com.example.motorbazar.Adapters.CarsAdapter;
import com.example.motorbazar.R;

public class Cars extends Fragment {
    RecyclerView cars_list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cars_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        cars_list=(RecyclerView) view.findViewById(R.id.car_list);
        cars_list.setLayoutManager(new LinearLayoutManager(getContext()));

        String [] price = {"12200000","5251000","7540000","500000"};



        cars_list.setAdapter(new CarsAdapter(price));
    }
}
