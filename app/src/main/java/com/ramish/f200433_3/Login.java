package com.ramish.f200433_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                                    // Login successful
                                    FirebaseUser user = auth.getCurrentUser();
                                    Toast.makeText(Login.this, "Welcome, " + user.getEmail(), Toast.LENGTH_SHORT).show();
                                    // Navigate to your dashboard or home activity
                                    Intent intent = new Intent(Login.this, dashboard.class);
                                    startActivity(intent);
                                    finish(); // Close the login activity
                                } else {
                                    // Login failed
                                    Toast.makeText(Login.this, "Login failed. Check your email and password.", Toast.LENGTH_SHORT).show();
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