package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void open_search(View view){
        Intent intent=new Intent(
                dashboard.this,
                search.class);
        startActivity(intent);
    }
    public void Open_add_item(View view){
        Intent intent=new Intent(
                dashboard.this,
                add_item.class);
        startActivity(intent);
    }
    public void OpenChat(View view){
        Intent intent=new Intent(
                dashboard.this,
                inbox.class);
        startActivity(intent);
    }
    public void OpenProfile(View view){
        Intent intent=new Intent(
                dashboard.this,
                my_profile.class);
        startActivity(intent);
    }
}