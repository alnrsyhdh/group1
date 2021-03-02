package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RentalFormSuits extends AppCompatActivity {

    String [] suits;
    private EditText getName, getIcNum, getPhoneNum, getAdd, getDate;
    String custSuits, name, IcNum, PhoneNum, Add, Date;
    private Button submit;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference mysuitsreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_form_suits);


        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        getName = findViewById(R.id.suits_custname);
        getIcNum = findViewById(R.id.suits_icnumber);
        getPhoneNum = findViewById(R.id.suits_pnoneNo);
        getAdd = findViewById(R.id.suits_address);
        getDate = findViewById(R.id.suits_date);
        submit = findViewById(R.id.suits_confirm);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        suits = getResources().getStringArray(R.array.suits_array);
        Spinner s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, suits);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),"You have selected item : " + suits[index], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        mysuitsreff = FirebaseDatabase.getInstance().getReference("Booked Suits").child(firebaseAuth.getUid());
        RentalSuitsData rentalSuitsData = new RentalSuitsData();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rentalSuitsData.setName(getName.getText().toString().trim());
                rentalSuitsData.setIcNum(getIcNum.getText().toString().trim());
                rentalSuitsData.setPhoneNum(getPhoneNum.getText().toString().trim());
                rentalSuitsData.setAdd(getAdd.getText().toString().trim());
                rentalSuitsData.setDate(getDate.getText().toString().trim());
                rentalSuitsData.setCustSuits(s2.getSelectedItem().toString().trim());
                mysuitsreff.push().setValue(rentalSuitsData);
                Toast.makeText(RentalFormSuits.this,"Your Order have been booked!! Thank You!", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(RentalFormSuits.this, PrintReceipt.class));
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