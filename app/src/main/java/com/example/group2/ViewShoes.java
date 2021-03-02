package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class ViewShoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_shoes);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ShoesData[] shoesData = new ShoesData[]{
                new ShoesData("Cinder Gella","rose gold","thick heels with straps","8","RM 50 PER DAY",R.drawable.shoes1),
                new ShoesData("Flower Belle","white gold","no heels with straps","9","RM 100 PER DAY",R.drawable.shoes2),
                new ShoesData("Classic Smoke","greyish","wedges with straps","6","RM 70 PER DAY",R.drawable.shoes3),
                new ShoesData("Anastasia","rose gold","thick heels with straps","7","RM 50 PER DAY",R.drawable.shoes4),
                new ShoesData("Classic Swarovski","rose gold","flat","5","RM 130 PER DAY",R.drawable.shoes5),
                new ShoesData("Summer Dior","matte black","almost flat","8","RM 70 PER DAY",R.drawable.kasut1),
                new ShoesData("Winter Chanel","shiny black","almost flat","8","RM 80 PER DAY",R.drawable.kasut2),
                new ShoesData("Fall Prada","velvet black","small heels","7","RM 70 PER DAY",R.drawable.kasut3),
                new ShoesData("Classic Gucci","shiny black","wedges","9","RM 100 PER DAY",R.drawable.kasut4),
                new ShoesData("Summer Chanel","velvet black","small heels","5","RM 80 PER DAY",R.drawable.kasut5),
        };

        ShoesAdapter shoesAdapter = new ShoesAdapter(shoesData, ViewShoes.this);
        recyclerView.setAdapter(shoesAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}