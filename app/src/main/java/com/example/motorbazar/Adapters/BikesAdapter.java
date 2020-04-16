package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;


public class BikesAdapter extends RecyclerView.Adapter<BikesAdapter.BikeViewHolder> {
    private String[] bikes;
    public BikesAdapter(String[] bikes){
        this.bikes = bikes;
    }

    @NonNull
    @Override
    public BikeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.vehicle_display_design,viewGroup,false);
        return new BikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BikeViewHolder bikeViewHolder, int i) {
        String price = bikes[i];
        bikeViewHolder.bike_price.setText(price);
    }

    @Override
    public int getItemCount() {
        return bikes.length;
    }

    public class BikeViewHolder extends RecyclerView.ViewHolder{

        TextView bike_price;
        public BikeViewHolder(@NonNull View itemView) {
            super(itemView);
            bike_price = itemView.findViewById(R.id.display_price);

        }
    }
}
