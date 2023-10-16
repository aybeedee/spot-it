package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class my_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
    }


    public void open_search(View view){
        Intent intent=new Intent(
                my_profile.this,
                search.class);
        startActivity(intent);
    }
    public void Open_add_item(View view){
        Intent intent=new Intent(
                my_profile.this,
                add_item.class);
        startActivity(intent);
    }
    public void OpenChat(View view){
        Intent intent=new Intent(
                my_profile.this,
                inbox.class);
        startActivity(intent);
    }
    public void OpenProfile(View view){
        Intent intent=new Intent(
                my_profile.this,
                my_profile.class);
        startActivity(intent);
    }
    public void openHome(View view){
        Intent intent=new Intent(
                my_profile.this,
                dashboard.class);
        startActivity(intent);
    }
    public void OpenEditProfile(View view){
        Intent intent=new Intent(
                my_profile.this,
                edit_profiel.class);
        startActivity(intent);
    }
    public void OpenAllItem(View view){
        Intent intent=new Intent(
                my_profile.this,
                search_result.class);
        startActivity(intent);
    }
    public void OpenItemDetail(View view){
        Intent intent=new Intent(
                my_profile.this,
                ItemDescription1Activity.class);
        startActivity(intent);
    }
}