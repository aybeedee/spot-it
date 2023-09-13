package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    Button sign_up;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Spinner countrySpinner = findViewById(R.id.spinner_country_dropdown);
        ArrayAdapter<CharSequence> countrySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.countries_array, R.layout.spinner_dropdown_item);
        countrySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countrySpinnerAdapter);

        Spinner citySpinner = findViewById(R.id.spinner_city_dropdown);
        ArrayAdapter<CharSequence> citySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.cities_array, R.layout.spinner_dropdown_item);
        citySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(citySpinnerAdapter);

        sign_up = findViewById(R.id.button_sign_up);
        login = findViewById(R.id.text_login);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, EmailVerification.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }
}