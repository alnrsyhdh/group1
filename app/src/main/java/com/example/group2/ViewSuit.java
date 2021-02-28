package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class ViewSuit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dress);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SuitData[] suitData = new SuitData[]{
                new SuitData("Basic Prada","royal blue","fit cut with white shirt and bow","M","RM 250 PER DAY",R.drawable.sprom1),
                new SuitData("Royal Suit","typical black","flat cut with white shirt and bow","L","RM 450 PER DAY",R.drawable.suitsw1),
                new SuitData("Casual Suit","matte black","fit cut with black shirt","XL","RM 150 PER DAY",R.drawable.sevent1),
                new SuitData("Typical Strips","white and black","loose cut with white shirt","S","RM 150 PER DAY",R.drawable.sprom2),
                new SuitData("Old Style","greenish","fit cut with white shirt and red bow","M","RM 250 PER DAY",R.drawable.suitsw2),
                new SuitData("Mocha Style","red-choco","fit cut","L","RM 450 PER DAY",R.drawable.sevent2),
                new SuitData("Grammys Night","Shiny Red Velvet","fit cut with black shirt","S","RM 150 PER DAY",R.drawable.sprom3),
                new SuitData("Classic King","matte black","fit cut with white shirt and black bow","L","RM 350 PER DAY",R.drawable.suitsw3),
                new SuitData("Simple Date","Choco & black-white","loose cut with strips shirt","M","RM 100 PER DAY",R.drawable.sevent3),
                new SuitData("Dolce Latte","Pastel Grey","fit cut with pastel shirt and tie","L","RM 450 PER DAY",R.drawable.suitsw4),
        };

        SuitAdapter suitAdapter = new SuitAdapter(suitData, ViewSuit.this);
        recyclerView.setAdapter(suitAdapter);
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