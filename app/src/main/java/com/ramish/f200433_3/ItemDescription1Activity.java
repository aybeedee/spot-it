package com.ramish.f200433_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ItemDescription1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_description_1);
    }
    public void OpenReport(View view){
        Intent intent=new Intent(
                ItemDescription1Activity.this,
                report_page.class);
        startActivity(intent);
    }
}