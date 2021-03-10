package com.example.group2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PrientReceiptSuits extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private TextView disSuits, disName, disIc, disPhone, disAdd, disDate;
    private Button backhome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prient_receipt_suits);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        disSuits = findViewById(R.id.tv_suitsname);
        disName = findViewById(R.id.tv_fullname);
        disIc = findViewById(R.id.tv_icnum);
        disPhone = findViewById(R.id.tv_phoneNo);
        disAdd = findViewById(R.id.tv_address);
        disDate = findViewById(R.id.tv_bookingDate);
        backhome = findViewById(R.id.btn_homesuits);

        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrientReceiptSuits.this, MenuProfile.class));
            }
        });

        DatabaseReference mySuitsRef = firebaseDatabase.getReference("Booked Suits").child(firebaseAuth.getUid());
        mySuitsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RentalSuitsData rentalSuitsData = dataSnapshot.getValue(RentalSuitsData.class);
                disSuits.setText(String.format("Suits Name: %s", rentalSuitsData.getCustSuits()));
                disName.setText(String.format("Full Name: %s", rentalSuitsData.getName()));
                disIc.setText(String.format("IC Number: %s", rentalSuitsData.getIcNum()));
                disPhone.setText(String.format("Phone Number: %s", rentalSuitsData.getPhoneNum()));
                disAdd.setText(String.format("Address: %s", rentalSuitsData.getAdd()));
                disDate.setText(String.format("Booked Date: %s", rentalSuitsData.getDate()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PrientReceiptSuits.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}