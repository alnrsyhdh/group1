package com.example.group2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ViewShoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_shoes);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ShoesData[] shoesData = new ShoesData[]{
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.sprom1),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.suitsw1),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.sevent1),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.sprom2),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.suitsw2),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.sevent2),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.sprom3),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.suitsw3),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.sevent3),
                new ShoesData("Cinder Gella","rose gold","heels with straps","5-9","RM 30 PER DAY",R.drawable.suitsw4),
        };

        ShoesAdapter shoesAdapter = new ShoesAdapter(shoesData, ViewShoes.this);
        recyclerView.setAdapter(shoesAdapter);
    }
}