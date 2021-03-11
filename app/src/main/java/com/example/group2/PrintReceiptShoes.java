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


public class PrintReceiptShoes extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private TextView disShoes, disName, disIc, disPhone, disAdd, disDate;
    private Button backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_receipt_shoes);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        disShoes = findViewById(R.id.tv_shoesname);
        disName = findViewById(R.id.tv_fullname);
        disIc = findViewById(R.id.tv_icnum);
        disPhone = findViewById(R.id.tv_phoneNo);
        disAdd = findViewById(R.id.tv_address);
        disDate = findViewById(R.id.tv_bookingDate);
        backhome = findViewById(R.id.btn_homeshoes);

        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrintReceiptShoes.this, MenuProfile.class));
            }
        });


        //SHOES
        DatabaseReference myShoesRef = firebaseDatabase.getReference("Booked Shoes").child(firebaseAuth.getUid());
        myShoesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RentalShoesData rentalShoesData = dataSnapshot.getValue(RentalShoesData.class);
                disShoes.setText(String.format("Item: %s", rentalShoesData.getCustShoes()));
                disName.setText(String.format("Full Name: %s", rentalShoesData.getName()));
                disIc.setText(String.format("IC Number: %s", rentalShoesData.getIcNum()));
                disPhone.setText(String.format("Phone Number: %s", rentalShoesData.getPhoneNum()));
                disAdd.setText(String.format("Address: %s", rentalShoesData.getAdd()));
                disDate.setText(String.format("Booked Date: %s", rentalShoesData.getDate()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PrintReceiptShoes.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}