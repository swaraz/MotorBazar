package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {

    String[] wishlist;

    public WishlistAdapter(String[] wishlist){
        this.wishlist = wishlist;
    }


    @NonNull
    @Override
    public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.wishlist_display_design,parent,false);
        return new WishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
        String price = wishlist[position];
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return wishlist.length;
    }

    public class WishlistViewHolder extends RecyclerView.ViewHolder{
        TextView price, model_name;
        public WishlistViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.txtPrice);
            model_name = itemView.findViewById(R.id.txtName);
        }
    }
}
