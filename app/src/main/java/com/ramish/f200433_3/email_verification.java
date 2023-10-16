package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class email_verification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);
    }
    public void BackPage(View view){
        Intent intent=new Intent(
                email_verification.this,
                RegistrationActivity.class);
        startActivity(intent);
    }
}