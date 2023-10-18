package com.ramish.f200433_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        email=findViewById(R.id.editTextEmail);
        password=findViewById(R.id.editTextPassword);
        login=findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                auth.signInWithEmailAndPassword(email1, password1)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = auth.getCurrentUser();
                                    String userEmail = user.getEmail();

                                    // Create a reference to your Firebase Realtime Database
                                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

                                    // Query the database to check if the email exists
                                    Query query = databaseReference.orderByChild("email").equalTo(userEmail);

                                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            if (dataSnapshot.exists()) {
                                                // Email found in the database
                                                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                                    String uid = userSnapshot.getKey();
                                                    Toast.makeText(Login.this, "UID: " + uid, Toast.LENGTH_SHORT).show();
                                                    // Navigate to your dashboard or home activity
                                                    Intent intent = new Intent(Login.this, dashboard.class);

                                                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    editor.putString("UID", user.getUid()); // Save the UID
                                                    editor.apply();


                                                    startActivity(intent);
                                                    finish(); // Close the login activity
                                                }
                                                // Email found in the database
                                                //Toast.makeText(Login.this, "Welcome, " + userEmail, Toast.LENGTH_SHORT).show();

//
                                            } else {
                                                // Email not found in the database
                                                Toast.makeText(Login.this, "Email not found in the database", Toast.LENGTH_SHORT).show();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {
                                            // Handle any database errors here
                                            Toast.makeText(Login.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    // Login failed
                                    Toast.makeText(Login.this, "Check your email and password.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
    public void OpenForgotPassword(View view){
        Intent intent=new Intent(
                Login.this,
                ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void OpenSignUp(View view){
        Intent intent=new Intent(Login.this, RegistrationActivity.class);
        startActivity(intent);
    }


}