package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class inbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
    }
    public void OpenMsg(View view){
        Intent intent=new Intent(
                inbox.this,
                chatting.class);
        startActivity(intent);
    }
    public void open_search(View view){
        Intent intent=new Intent(
                inbox.this,
                search.class);
        startActivity(intent);
    }
    public void Open_add_item(View view){
        Intent intent=new Intent(
                inbox.this,
                add_item.class);
        startActivity(intent);
    }
    public void OpenChat(View view){
        Intent intent=new Intent(
                inbox.this,
                inbox.class);
        startActivity(intent);
    }
    public void OpenProfile(View view){
        Intent intent=new Intent(
                inbox.this,
                my_profile.class);
        startActivity(intent);
    }
    public void OpenDashboard(View view){
        Intent intent=new Intent(
                inbox.this,
                dashboard.class);
        startActivity(intent);
    }
}