package com.ramish.f200433_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //placing name on welcome at dashboard page
        // In the dashboard activity
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userUid = sharedPreferences.getString("UID", null); // Retrieve the UID

        // Create a reference to your Firebase Realtime Database
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

    // Query the database to get the user's name by UID
            Query query = databaseReference.child(userUid).child("name");
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String userName = dataSnapshot.getValue(String.class);
                        // Set the retrieved name to the TextView
                        TextView nameTextView = findViewById(R.id.nameTitle);
                        nameTextView.setText(userName);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any database errors here
                    Toast.makeText(dashboard.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


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