package com.example.group2;

import android.content.Intent;
import android.hardware.usb.UsbEndpoint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustFeedback extends AppCompatActivity {

    private EditText Username, Feedback, Fullname;
    String username, feedback, fullname;
    private Button send;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_feedback);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Username = (EditText)findViewById(R.id.pt_username);
        Feedback = (EditText)findViewById(R.id.pt_feedback);
        Fullname = findViewById(R.id.pt_fullname);
        send = findViewById(R.id.btn_sendFeedback);



        reff = FirebaseDatabase.getInstance().getReference("Feedback").child(firebaseAuth.getUid());
        FeedbackDatabase feedbackDatabase = new FeedbackDatabase(fullname, username, feedback);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackDatabase.setFullname(Fullname.getText().toString().trim());
                feedbackDatabase.setUsername(Username.getText().toString().trim());
                feedbackDatabase.setFeedback(Feedback.getText().toString().trim());
                reff.push().setValue(feedbackDatabase);
                Toast.makeText(CustFeedback.this,"Your feedback has been sent.", Toast.LENGTH_LONG).show();
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