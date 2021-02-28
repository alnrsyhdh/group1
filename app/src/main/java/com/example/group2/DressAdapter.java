package com.example.group2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DressAdapter extends RecyclerView.Adapter<DressAdapter.ViewHolder>{

    DressData[] dressData;
    Context context;


    public DressAdapter(DressData[] dressData, ViewDress activity) {
        this.dressData = dressData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dress_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DressData dressDataList = dressData[position];

        holder.textViewName.setText(dressDataList.getDressName());
        holder.textViewColour.setText(dressDataList.getDressColour());
        holder.textViewDetails.setText(dressDataList.getDressDetails());
        holder.textViewSize.setText(dressDataList.getDressSize());
        holder.textViewPrice.setText(dressDataList.getDressPrice());
        holder.dressImage.setImageResource(dressDataList.getDressImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dressDataList.getDressName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView dressImage;
        TextView textViewName;
        TextView textViewColour;
        TextView textViewDetails;
        TextView textViewSize;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dressImage = itemView.findViewById(R.id.iv_prom1);
            textViewName = itemView.findViewById(R.id.tv_product);
            textViewColour = itemView.findViewById(R.id.tv_colour);
            textViewDetails = itemView.findViewById(R.id.tv_details);
            textViewSize= itemView.findViewById(R.id.tv_size);
            textViewPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
