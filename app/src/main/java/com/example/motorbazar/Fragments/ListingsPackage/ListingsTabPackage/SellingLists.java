package com.example.motorbazar.Fragments.ListingsPackage.ListingsTabPackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.Adapters.SellingsAdapter;
import com.example.motorbazar.R;

public class SellingLists extends Fragment {
    RecyclerView sellings_recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sellings_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sellings_recyclerView = view.findViewById(R.id.sellings_list);
        sellings_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        String [] price = {"1000000","5000000","7000000","500000"};
        sellings_recyclerView.setAdapter(new SellingsAdapter(price));
    }
}
