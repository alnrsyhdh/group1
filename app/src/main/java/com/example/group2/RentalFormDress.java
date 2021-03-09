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


public class RentalFormDress extends AppCompatActivity {

    String [] dress;
    private EditText getName, getIcNum, getPhoneNum, getAdd, getDate;
    String custDress, name, IcNum, PhoneNum, Add, Date;
    private Button submit;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference mydressreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_form_dress);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        
        getName = findViewById(R.id.dress_custname);
        getIcNum = findViewById(R.id.dress_icnumber);
        getPhoneNum = findViewById(R.id.dress_pnoneNo);
        getAdd = findViewById(R.id.dress_address);
        getDate = findViewById(R.id.dress_date);
        submit = findViewById(R.id.dress_confirm);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dress = getResources().getStringArray(R.array.dress_array);
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, dress);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),"You have selected item : " + dress[index], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        mydressreff = FirebaseDatabase.getInstance().getReference("Booked Dress").child(firebaseAuth.getUid());
        RentalDressData rentalDressData = new RentalDressData();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rentalDressData.setName(getName.getText().toString().trim());
                rentalDressData.setIcNum(getIcNum.getText().toString().trim());
                rentalDressData.setPhoneNum(getPhoneNum.getText().toString().trim());
                rentalDressData.setAdd(getAdd.getText().toString().trim());
                rentalDressData.setDate(getDate.getText().toString().trim());
                rentalDressData.setCustDress(s1.getSelectedItem().toString().trim());
                mydressreff.push().setValue(rentalDressData);
                Toast.makeText(RentalFormDress.this,"Your Order have been booked!! Thank You!", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(RentalFormDress.this, MenuProfile.class));
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