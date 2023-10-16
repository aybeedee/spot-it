package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
    }
    public void Homepage(View view){
        Intent intent=new Intent(
                ForgotPasswordActivity.this,
                MainActivity.class);
        startActivity(intent);
    }
}