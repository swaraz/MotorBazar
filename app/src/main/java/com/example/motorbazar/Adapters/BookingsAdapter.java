package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;

public class BookingsAdapter extends RecyclerView.Adapter<BookingsAdapter.BookingsViewHolder> {

    String [] bookings_list;

    public BookingsAdapter(String [] bookings_list){
        this.bookings_list = bookings_list;
    }

    @NonNull
    @Override
    public BookingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.wishlist_display_design, parent, false);
        return new BookingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingsViewHolder holder, int position) {
        String price = bookings_list[position];
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return bookings_list.length;
    }

    public class BookingsViewHolder extends RecyclerView.ViewHolder{

        TextView price;
        ImageView image;
        public BookingsViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.txtPrice);
        }
    }
}
