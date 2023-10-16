package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText name,email,contact,password;
    Spinner citySpinner,countrySpinner;

    Button signup;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        auth = FirebaseAuth.getInstance();
        signup = findViewById(R.id.buttonSignUp);
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        contact = findViewById(R.id.editTextContact);
        password = findViewById(R.id.editTextPassword);
        citySpinner = findViewById(R.id.spinnerCity1);
        countrySpinner = findViewById(R.id.spinnerCountry);

        ArrayAdapter<CharSequence> citySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.citiesPakistan, android.R.layout.simple_spinner_item);
        citySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(citySpinnerAdapter);

        ArrayAdapter<CharSequence> countrySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.Countries, android.R.layout.simple_spinner_item);
        countrySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countrySpinnerAdapter);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button click code goes here

                String name1,email1, password1,contact1,city1,country1;
                name1=name.getText().toString();
                email1 = email.getText().toString();
                password1 = password.getText().toString();
                contact1=contact.getText().toString();
                city1=citySpinner.getSelectedItem().toString();
                country1=countrySpinner.getSelectedItem().toString();
                

                auth.createUserWithEmailAndPassword(email1, password1)
                        .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User account created successfully, now send email verification
                                    FirebaseUser user = auth.getCurrentUser();
                                    if (user != null) {
                                        user.sendEmailVerification()
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> emailTask) {
                                                        if (emailTask.isSuccessful()) {

                                                            // Save user data to Firebase Realtime Database
                                                            
                                                            String uid = user.getUid();
//                                                            User user=(uid,name,email,contact,citySpinner,countrySpinner);
                                                            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(uid);
                                                            userRef.child("name").setValue(name1);
                                                            userRef.child("email").setValue(email1);
                                                            userRef.child("contact").setValue(contact1);
                                                            userRef.child("city").setValue(city1);
                                                            userRef.child("country").setValue(country1);


                                                            Toast.makeText(RegistrationActivity.this, "Verification code sent", Toast.LENGTH_LONG).show();
                                                            Intent intent = new Intent(RegistrationActivity.this, dashboard.class);
                                                            intent.putExtra("user_id",uid);
                                                            startActivity(intent);
                                                        } else {
                                                            Toast.makeText(RegistrationActivity.this, "Verification code failed", Toast.LENGTH_LONG).show();
                                                        }
                                                    }
                                                });
                                    }
                                } else {
                                    Toast.makeText(RegistrationActivity.this, "User account not made", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

//                // Create an intent to navigate to the email verification page
//                Intent intent = new Intent(RegistrationActivity.this, email_verification.class);
//                // Pass the user data as extras in the intent
//                intent.putExtra("userName", name.getText().toString());
//                intent.putExtra("userEmail", email.getText().toString());
//                intent.putExtra("userContact", contact.getText().toString());
//                intent.putExtra("userPassword", password.getText().toString());
//                intent.putExtra("selectedCity", citySpinner.getSelectedItem().toString());
//                intent.putExtra("selectedCountry", countrySpinner.getSelectedItem().toString());
//                startActivity(intent);
            }
        });
    }
    public void Homepage(View view){
        Intent intent=new Intent(
                RegistrationActivity.this,
                MainActivity.class);
        startActivity(intent);
    }
}