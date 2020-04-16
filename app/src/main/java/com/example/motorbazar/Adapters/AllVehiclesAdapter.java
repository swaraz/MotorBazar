package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;

import java.util.ArrayList;

public class AllVehiclesAdapter extends RecyclerView.Adapter<AllVehiclesAdapter.VehicleViewHolder> {

    private String [] vehicledata;

    public AllVehiclesAdapter(String[] vehicledata){
        this.vehicledata = vehicledata;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.vehicle_display_design,viewGroup,false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder vehicleViewHolder, final int i) {
        String price = vehicledata[i];
        vehicleViewHolder.price.setText(price);

        vehicleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "position "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicledata.length;
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder{
        ImageView vehicle_image,addToWishlist;
        TextView price;


        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            price =itemView.findViewById(R.id.display_price);
            vehicle_image = itemView.findViewById(R.id.vehicle_image);
            addToWishlist =itemView.findViewById(R.id.addToWishlist);

            addToWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "wishlist clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
