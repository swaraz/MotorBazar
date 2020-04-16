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

import com.example.motorbazar.Adapters.SoldAdapter;
import com.example.motorbazar.R;

public class SoldLists extends Fragment {
    RecyclerView soldItems_view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sold_items_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        soldItems_view = view.findViewById(R.id.sold_list);
        soldItems_view.setLayoutManager(new LinearLayoutManager(getContext()));

        String [] price = {"1000000","5000000","7000000","500000"};
        soldItems_view.setAdapter(new SoldAdapter(price));
    }
}
