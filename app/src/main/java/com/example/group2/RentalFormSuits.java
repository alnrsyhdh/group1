package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class RentalFormSuits extends AppCompatActivity implements View.OnClickListener {

    String [] suits;
    private EditText getName, getIcNum, getPhoneNum, getAdd, getDate;
    String custSuits, name, IcNum, PhoneNum, Add, Date;
    private Button submit, btnDatePicker;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference mysuitsreff;

    private int mYear, mMonth, mDay;

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
        btnDatePicker = findViewById(R.id.btn_datesuits);

        btnDatePicker.setOnClickListener(this);


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

                addNotification();
                rentalSuitsData.setName(getName.getText().toString().trim());
                rentalSuitsData.setIcNum(getIcNum.getText().toString().trim());
                rentalSuitsData.setPhoneNum(getPhoneNum.getText().toString().trim());
                rentalSuitsData.setAdd(getAdd.getText().toString().trim());
                rentalSuitsData.setDate(getDate.getText().toString().trim());
                rentalSuitsData.setCustSuits(s2.getSelectedItem().toString().trim());
                mysuitsreff.setValue(rentalSuitsData);

                name = getName.getText().toString();
                IcNum = getIcNum.getText().toString();
                PhoneNum = getPhoneNum.getText().toString();
                Add = getAdd.getText().toString();
                Date = getDate.getText().toString();


                if (name.isEmpty() || IcNum.isEmpty() || PhoneNum.isEmpty() || Add.isEmpty() || Date.isEmpty()) {
                    Toast.makeText(RentalFormSuits.this, "Please enter all the details again", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RentalFormSuits.this,"Order submitted!", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(RentalFormSuits.this, PrientReceiptSuits.class));
                }

            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            getDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

    }


    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.fr_icon)
                .setColor(Color.MAGENTA)
                .setContentTitle("FlairRiental")
                .setContentText("Thank you for your booking! Your suits is successfully booked.");

        Intent notificationIntent = new Intent(this, MenuProfile.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
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