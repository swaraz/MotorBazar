package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarViewHolder> {
    String[] cars;

    public CarsAdapter(String[] cars){
        this.cars = cars;
    }
    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.vehicle_display_design, viewGroup, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {
        String price = cars[i];
        carViewHolder.car_price.setText(price);
    }

    @Override
    public int getItemCount() {
        return cars.length;
    }

    public class CarViewHolder extends RecyclerView.ViewHolder{
        TextView car_price;
        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            car_price = itemView.findViewById(R.id.display_price);
        }
    }
}
