package com.example.motorbazar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.motorbazar.R;

public class SellingsAdapter extends RecyclerView.Adapter<SellingsAdapter.SellingsViewHolder> {

    String[] sellings;

    public SellingsAdapter(String[] sellings){
        this.sellings = sellings;
    }

    @NonNull
    @Override
    public SellingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sellings_display_design, parent,false);
        return new SellingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellingsViewHolder holder, int position) {
        String price = sellings[position];
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return sellings.length;
    }

    public class SellingsViewHolder extends RecyclerView.ViewHolder{
        TextView price;
        ImageView image;
        Button soldBtn, DeleteBtn;
        public SellingsViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.sellings_Price);
        }
    }
}
