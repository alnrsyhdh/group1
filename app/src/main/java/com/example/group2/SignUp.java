package com.example.group2;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class SignUp extends AppCompatActivity {

    private EditText userName, userEmail, userPassword, userAge;
    private Button signupButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    private ImageView userProfilePic;
    String email, name, age, password;
    private FirebaseStorage firebaseStorage;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    private StorageReference storageReference;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                userProfilePic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        storageReference = firebaseStorage.getReference();

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);
            }
        });



        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    if (validate()) {
                        String user_name = userName.getText().toString().trim();
                        String user_email = userEmail.getText().toString().trim();
                        String user_password = userPassword.getText().toString().trim();

                        firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                    {
                                        sendEmailVerification();
                                    }
                                    else
                                        {
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
        userName = (EditText) findViewById(R.id.etNameUpdate);
        userEmail = (EditText) findViewById(R.id.etEmailUpdate);
        userPassword = (EditText) findViewById(R.id.password_signup);
        signupButton = (Button) findViewById(R.id.bt_signup);
        userLogin = (TextView) findViewById(R.id.tv_backtologin);
        userAge = (EditText) findViewById(R.id.etAgeUpdate);
        userProfilePic = (ImageView)findViewById(R.id.ivProfile);
    }

    private Boolean validate() {
        Boolean result = false;
        name = userName.getText().toString();
        email = userEmail.getText().toString();
        password = userPassword.getText().toString();
        age = userAge.getText().toString();

        if (name.isEmpty() && email.isEmpty() && password.isEmpty() && age.isEmpty() && imagePath==null) {
            Toast.makeText(this, "Please enter all the details again", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }

    private void sendEmailVerification()
        {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

            if (firebaseUser != null)
                {
                    firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                                {
                                    sendUserData();
                                    firebaseAuth.signOut();
                                   Toast.makeText(SignUp.this, "Successfully registered! Verification mail has been sent.", Toast.LENGTH_SHORT).show();;
                                    firebaseAuth.signOut();
                                    finish();
                                    startActivity(new Intent(SignUp.this, MainActivity.class));
                                }
                                else
                                    {
                                        //if got internet problem or cannot be sent
                                        Toast.makeText(SignUp.this, "Verification mail has not been sent.", Toast.LENGTH_SHORT).show();
                                    }
                        }
                    });
                }
        }

        private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Picture"); //User Id/Images/Profile_pic
        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp.this, "Upload Failed!", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(SignUp.this, "Upload Successful!", Toast.LENGTH_SHORT).show();
            }
        });
        UserProfile userProfile = new UserProfile(age, email, name);
        myRef.setValue(userProfile);

    }
}