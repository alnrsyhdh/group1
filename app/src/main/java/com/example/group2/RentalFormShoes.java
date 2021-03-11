package com.example.group2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
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

public class RentalFormShoes extends AppCompatActivity {

    String [] shoes;
    private EditText getName, getIcNum, getPhoneNum, getAdd, getDate;
    String custShoes, name, IcNum, PhoneNum, Add, Date;
    private Button submit;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference myshoesreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_form_shoes);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        getName = findViewById(R.id.shoes_custname);
        getIcNum = findViewById(R.id.shoes_icnumber);
        getPhoneNum = findViewById(R.id.shoes_pnoneNo);
        getAdd = findViewById(R.id.shoes_address);
        getDate = findViewById(R.id.shoes_date);
        submit = findViewById(R.id.shoes_confirm);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        shoes = getResources().getStringArray(R.array.shoes_array);
        Spinner s3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, shoes);
        s3.setAdapter(adapter);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),"You have selected item : " + shoes[index], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        myshoesreff = FirebaseDatabase.getInstance().getReference("Booked Shoes").child(firebaseAuth.getUid());
        RentalShoesData rentalShoesData = new RentalShoesData();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
                rentalShoesData.setName(getName.getText().toString().trim());
                rentalShoesData.setIcNum(getIcNum.getText().toString().trim());
                rentalShoesData.setPhoneNum(getPhoneNum.getText().toString().trim());
                rentalShoesData.setAdd(getAdd.getText().toString().trim());
                rentalShoesData.setDate(getDate.getText().toString().trim());
                rentalShoesData.setCustShoes(s3.getSelectedItem().toString().trim());
                myshoesreff.setValue(rentalShoesData);
                Toast.makeText(RentalFormShoes.this,"Your Order have been booked!! Thank You!", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(RentalFormShoes.this, PrintReceiptShoes.class));
            }
        });



    }

    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.fr_icon)
                .setColor(Color.MAGENTA)
                .setContentTitle("FlairRiental")
                .setContentText("Thank you for your booking! Your shoes is successfully booked.");

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
