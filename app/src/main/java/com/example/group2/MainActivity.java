package com.example.group2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userName, userPassword;
    private Button loginButton;
    private TextView userSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //upload data to database
                }

            }
        });
        userSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent(SignUp.this, MainActivity.class));

            }
        });

    }

    private void setupUIViews() {
        userName = (EditText) findViewById(R.id.pt_name);
        userPassword = (EditText) findViewById(R.id.password_signup);
        loginButton = (Button) findViewById(R.id.bt_login);
        userSignUp = (TextView) findViewById(R.id.tv_signup);
    }

    private Boolean validate() {
        Boolean result = false;
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();

        if (name.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Please enter all the details again", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;


    }
}