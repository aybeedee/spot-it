package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SearchResults extends AppCompatActivity {

    ImageView back_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        back_search = findViewById(R.id.image_back_search);

        back_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchResults.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}