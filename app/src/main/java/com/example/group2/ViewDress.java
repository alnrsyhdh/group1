package com.example.group2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ViewDress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dress);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DressData[] dressData = new DressData[]{
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.prom1),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.wedding1),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.event1),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.prom2),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.wedding2),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.event2),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.prom3),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.wedding3),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.event3),
                new DressData("Donna Gold","Sparkly Gold","fit and flare with deep v-neck","S-XL","RM 250 PER DAY",R.drawable.wedding4),
        };

        DressAdapter dressAdapter = new DressAdapter(dressData, ViewDress.this);
        recyclerView.setAdapter(dressAdapter);
    }
}