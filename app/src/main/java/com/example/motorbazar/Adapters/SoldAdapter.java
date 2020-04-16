package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;

public class SoldAdapter extends RecyclerView.Adapter<SoldAdapter.SoldViewHolder> {

    String[] soldItems;

    public SoldAdapter(String[] soldItems){
        this.soldItems = soldItems;
    }

    @NonNull
    @Override
    public SoldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.wishlist_display_design,parent,false);
        return new SoldViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoldViewHolder holder, int position) {
        String price = soldItems[position];
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return soldItems.length;
    }

    public class SoldViewHolder extends RecyclerView.ViewHolder{
        TextView price;
        ImageView vehicle_image;
        TextView model_name;
        public SoldViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.txtPrice);

        }
    }
}
