package com.example.group2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustFeedback extends AppCompatActivity {

    private EditText username, feedback, fullname;
    private Button undo;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_feedback);
        username = (EditText)findViewById(R.id.pt_username);
        feedback = (EditText)findViewById(R.id.pt_feedback);
        fullname = findViewById(R.id.pt_fullname);
        undo = findViewById(R.id.btn_undo);
        Firebase.setAndroidContext(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustFeedback.this, MenuProfile.class));
            }
        });


    }

    public void feedbacksent (View view)
    {
        DatabaseReference databaseReference = firebaseDatabase.getReference("Feedback").child(firebaseAuth.getUid());
        String usernameinput = username.getText().toString();
        String fullnameinput = fullname.getText().toString();
        String feedbackinput = feedback.getText().toString();
        databaseReference.setValue(usernameinput);
        databaseReference.setValue(fullnameinput);
        databaseReference.setValue(feedbackinput);
        Toast.makeText(this,"Your feedback has been sent.", Toast.LENGTH_LONG).show();

    }


}