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

public class PrintReceipt extends AppCompatActivity {

    //DRESS ONLY
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private TextView disDress, disName, disIc, disPhone, disAdd, disDate, disPrice;
    private Button backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_receipt);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        disDress = findViewById(R.id.tv_dressname);
        disName = findViewById(R.id.tv_fullname);
        disIc = findViewById(R.id.tv_icnum);
        disPhone = findViewById(R.id.tv_phoneNo);
        disAdd = findViewById(R.id.tv_address);
        disDate = findViewById(R.id.tv_bookingDate);
        disPrice = findViewById(R.id.tv_dressprice);
        backhome = findViewById(R.id.btn_homedress);

        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrintReceipt.this, MenuProfile.class));
            }
        });

        //DRESS
        DatabaseReference myDressRef = firebaseDatabase.getReference("Booked Dress").child(firebaseAuth.getUid());
        myDressRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                RentalDressData rentalDressData = dataSnapshot.getValue(RentalDressData.class);
                disDress.setText(String.format("Dress: %s", rentalDressData.getCustDress()));
                disName.setText(String.format("Full Name: %s", rentalDressData.getName()));
                disIc.setText(String.format("IC Number: %s", rentalDressData.getIcNum()));
                disPhone.setText(String.format("Phone Number: %s", rentalDressData.getPhoneNum()));
                disAdd.setText(String.format("City: %s", rentalDressData.getAdd()));
                disDate.setText(String.format("Booked Date: %s", rentalDressData.getDate()));
                disPrice.setText(String.format("Price: %s", rentalDressData.getPrice()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PrintReceipt.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });


    }

}