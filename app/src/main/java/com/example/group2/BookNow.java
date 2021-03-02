package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BookNow extends AppCompatActivity {

    private Button bookdress, booksuit, bookshoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bookdress = findViewById(R.id.btn_bookDress);
        booksuit = findViewById(R.id.btn_bookSuits);
        bookshoes = findViewById(R.id.btn_bookShoes);

        bookdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookNow.this, RentalFormDress.class));
            }
        });

        booksuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookNow.this, RentalFormSuits.class));
            }
        });

        bookshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookNow.this, RentalFormShoes.class));
            }
        });
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