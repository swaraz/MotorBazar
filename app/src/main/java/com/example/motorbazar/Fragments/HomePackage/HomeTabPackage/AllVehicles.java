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
import com.example.motorbazar.R;

public class AllVehicles extends Fragment {
    RecyclerView allVehiclesList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.all_vehicles_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        allVehiclesList=(RecyclerView) view.findViewById(R.id.All_vehicle_list);
        allVehiclesList.setLayoutManager(new LinearLayoutManager(getContext()));

        String [] price = {"10000","50000","70000","5000"};

        allVehiclesList.setAdapter(new AllVehiclesAdapter(price));
    }
}
