package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.app.DatePickerDialog;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class RentalFormDress extends AppCompatActivity implements View.OnClickListener {

    String [] dress;
    private EditText getName, getIcNum, getPhoneNum, getAdd, getDate;
    private String custDress, name, IcNum, PhoneNum, Add, Date, Price;
    private Button submit, btnDatePicker;
    private DatePickerDialog datePickerDialog;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference mydressreff;

    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_form_dress);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        
        getName = findViewById(R.id.tv_fullname);
        getIcNum = findViewById(R.id.tv_icnum);
        getPhoneNum = findViewById(R.id.tv_phoneNo);
        getAdd = findViewById(R.id.tv_address);
        getDate = findViewById(R.id.dress_date);
        submit = findViewById(R.id.dress_confirm);
        btnDatePicker = findViewById(R.id.btn_datedress);

        btnDatePicker.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dress = getResources().getStringArray(R.array.dress_array);
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dress);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();

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
                addNotification();
                rentalDressData.setName(getName.getText().toString().trim());
                rentalDressData.setIcNum(getIcNum.getText().toString().trim());
                rentalDressData.setPhoneNum(getPhoneNum.getText().toString().trim());
                rentalDressData.setAdd(getAdd.getText().toString().trim());
                rentalDressData.setDate(getDate.getText().toString().trim());
                rentalDressData.setCustDress(s1.getSelectedItem().toString().trim());


                String dress = s1.getSelectedItem().toString().trim();
                if(dress.equals("Donna Gold")){
                    Price="RM250.00";
                }else if(dress.equals("Classic Gown")){
                    Price="RM450.00";
                }else if(dress.equals("Belt Blouse")) {
                    Price = "RM150.00";
                }else if(dress.equals("Frozen Flower")) {
                    Price = "RM300.00";
                }else if(dress.equals("Classic Wavy")) {
                    Price = "RM450.00";
                }else if(dress.equals("Ribbon Blouse")) {
                    Price = "RM100.00";
                }else if(dress.equals("Ariana Gown")) {
                    Price = "RM250.00";
                }else if(dress.equals("Bright Angel")) {
                    Price = "RM350.00";
                }else if(dress.equals("Sky Castle")) {
                    Price = "RM250.00";
                }else if(dress.equals("Royal Gown")) {
                    Price = "RM550.00";
                }else{
                    Price = "RM0.00";
                }


                rentalDressData.setPrice(Price);

                mydressreff.setValue(rentalDressData);

                name = getName.getText().toString();
                IcNum = getIcNum.getText().toString();
                PhoneNum = getPhoneNum.getText().toString();
                Add = getAdd.getText().toString();
                Date = getDate.getText().toString();


                if (name.isEmpty() || IcNum.isEmpty() || PhoneNum.isEmpty() || Add.isEmpty() || Date.isEmpty()) {
                    Toast.makeText(RentalFormDress.this, "Please enter all the details again", Toast.LENGTH_SHORT).show();
                }
                else {
                    finish();
                    startActivity(new Intent(RentalFormDress.this, PrintReceipt.class));
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
                .setSmallIcon(R.drawable.logoo)
                .setColor(Color.MAGENTA)
                .setContentTitle("FlairRiental")
                .setContentText("Thank you for your booking! Your dress is successfully booked.");

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