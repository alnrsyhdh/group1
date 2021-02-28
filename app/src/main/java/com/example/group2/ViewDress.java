package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class ViewDress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dress);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DressData[] dressData = new DressData[]{
                new DressData("Donna Gold","Sparkly Gold","topless for the back sides","M","RM 250 PER DAY",R.drawable.prom1),
                new DressData("Classic Gown","Snowy White","ball gown with deep v-neck","XL","RM 450 PER DAY",R.drawable.wedding1),
                new DressData("Belt Blouse","Soft Pink","fit and long sleeve","L","RM 150 PER DAY",R.drawable.event1),
                new DressData("Frozen Flower","Soft Blue","fit to the chest and ball gown","S","RM 300 PER DAY",R.drawable.prom2),
                new DressData("Classic Wavy","Milky White","semi ball gown with deep v-cut from neck to chest","XL","RM 450 PER DAY",R.drawable.wedding2),
                new DressData("Ribbon Blouse","Smokey Grey","fit and sleeveless","S","RM 100 PER DAY",R.drawable.event2),
                new DressData("Ariana Gown","Mighty Grey","ball gown with long-sleeve","M","RM 250 PER DAY",R.drawable.prom3),
                new DressData("Bright Angel ","Pearly White","fit and flare with deep v-neck","L","RM 350 PER DAY",R.drawable.wedding3),
                new DressData("Sky Castle","White and Blue","long straight dress","M","RM 250 PER DAY",R.drawable.event3),
                new DressData("Royal Gown","Ivory White","ball gown with deep v-neck","XL","RM 550 PER DAY",R.drawable.wedding4),
        };

        DressAdapter dressAdapter = new DressAdapter(dressData, ViewDress.this);
        recyclerView.setAdapter(dressAdapter);
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