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

public class SuitAdapter extends RecyclerView.Adapter<SuitAdapter.ViewHolder>{

    SuitData[] suitData;
    Context context;


    public SuitAdapter(SuitData[] suitData, ViewSuit activity) {
        this.suitData = suitData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.suit_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SuitData suitDataList = suitData[position];

        holder.textViewName.setText(suitDataList.getSuitName());
        holder.textViewColour.setText(suitDataList.getSuitColour());
        holder.textViewDetails.setText(suitDataList.getSuitDetails());
        holder.textViewSize.setText(suitDataList.getSuitSize());
        holder.textViewPrice.setText(suitDataList.getSuitPrice());
        holder.suitImage.setImageResource(suitDataList.getSuitImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, suitDataList.getSuitName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView suitImage;
        TextView textViewName;
        TextView textViewColour;
        TextView textViewDetails;
        TextView textViewSize;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            suitImage = itemView.findViewById(R.id.iv_mprom1);
            textViewName = itemView.findViewById(R.id.tv_mproduct);
            textViewColour = itemView.findViewById(R.id.tv_mcolour);
            textViewDetails = itemView.findViewById(R.id.tv_mdetails);
            textViewSize= itemView.findViewById(R.id.tv_msize);
            textViewPrice = itemView.findViewById(R.id.tv_mprice);
        }
    }
}

