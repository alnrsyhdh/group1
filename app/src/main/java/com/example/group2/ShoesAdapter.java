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

public class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ViewHolder>{

    ShoesData[] shoesData;
    Context context;


    public ShoesAdapter(ShoesData[] shoesData, ViewShoes activity) {
        this.shoesData = shoesData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.shoes_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ShoesData shoesDataList = shoesData[position];

        holder.textViewName.setText(shoesDataList.getShoesName());
        holder.textViewColour.setText(shoesDataList.getShoesColour());
        holder.textViewDetails.setText(shoesDataList.getShoesDetails());
        holder.textViewSize.setText(shoesDataList.getShoesSize());
        holder.textViewPrice.setText(shoesDataList.getShoesPrice());
        holder.shoesImage.setImageResource(shoesDataList.getShoesImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, shoesDataList.getShoesName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView shoesImage;
        TextView textViewName;
        TextView textViewColour;
        TextView textViewDetails;
        TextView textViewSize;
        TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shoesImage = itemView.findViewById(R.id.iv_promshoes1);
            textViewName = itemView.findViewById(R.id.tv_shoeproduct);
            textViewColour = itemView.findViewById(R.id.tv_shoecolour);
            textViewDetails = itemView.findViewById(R.id.tv_shoedetails);
            textViewSize= itemView.findViewById(R.id.tv_shoesize);
            textViewPrice = itemView.findViewById(R.id.tv_shoeprice);
        }
    }
}
