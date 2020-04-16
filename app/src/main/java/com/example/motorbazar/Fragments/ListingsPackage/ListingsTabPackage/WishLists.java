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

import com.example.motorbazar.Adapters.WishlistAdapter;
import com.example.motorbazar.R;

public class WishLists extends Fragment {

    RecyclerView wishlist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wishlists_viewpager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        wishlist = view.findViewById(R.id.wish_list);
        wishlist.setLayoutManager(new LinearLayoutManager(getContext()));

        String [] price = {"1000000","5000000","7000000","500000"};
        wishlist.setAdapter(new WishlistAdapter(price));


    }
}
