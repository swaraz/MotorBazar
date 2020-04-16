package com.example.motorbazar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.Adapters.BookingsAdapter;
import com.example.motorbazar.R;
import com.google.android.material.tabs.TabLayout;

public class BookingsFragment extends Fragment {
    RecyclerView bookings_recycler_view;
    private Toolbar bookings_toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bookings_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        uiInitialize(view);

        //setting up tool bar
        bookings_toolbar.setTitle("Bookings");
        ((AppCompatActivity)getActivity()).setSupportActionBar(bookings_toolbar);

        bookings_recycler_view = view.findViewById(R.id.bookings_list);
        bookings_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        String [] price = {"1000000","5000000","7000000","500000"};
        bookings_recycler_view.setAdapter(new BookingsAdapter(price));
    }

    public void uiInitialize(View view){
        bookings_toolbar = view.findViewById(R.id.bookings_toolbar);

    }
}
