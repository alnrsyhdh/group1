package com.example.group2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText userName, userEmail, userPhoneNumber, userPassword;
    private Button signupButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    if (validate()) {
                        String user_name = userName.getText().toString().trim();
                        String user_email = userEmail.getText().toString().trim();
                        String user_password = userPassword.getText().toString().trim();
                        String user_phone_number = userPhoneNumber.getText().toString().trim();

                        firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignUp.this, MainActivity.class));
                                }else{
                                    Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                }

            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });

    }

    private void setupUIViews() {
        userName = (EditText) findViewById(R.id.pt_name);
        userEmail = (EditText) findViewById(R.id.email);
        userPhoneNumber = (EditText) findViewById(R.id.Nophone);
        userPassword = (EditText) findViewById(R.id.password_signup);
        signupButton = (Button) findViewById(R.id.bt_signup);
        userLogin = (TextView) findViewById(R.id.tv_backtologin);
    }

    private Boolean validate() {
        Boolean result = false;
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String noPhone = userPhoneNumber.getText().toString();
        String password = userPassword.getText().toString();

        if (name.isEmpty() && email.isEmpty() && noPhone.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Please enter all the details again", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }
}