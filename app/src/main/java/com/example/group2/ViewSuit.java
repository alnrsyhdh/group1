package com.example.group2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ViewSuit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dress);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SuitData[] suitData = new SuitData[]{
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.sprom1),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.suitsw1),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.sevent1),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.sprom2),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.suitsw2),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.sevent2),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.sprom3),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.suitsw3),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.sevent3),
                new SuitData("Notch Suit","midnight blue","fit cut with white shirt and bow","S-XL","RM 250 PER DAY",R.drawable.suitsw4),
        };

        SuitAdapter suitAdapter = new SuitAdapter(suitData, ViewSuit.this);
        recyclerView.setAdapter(suitAdapter);
    }
}