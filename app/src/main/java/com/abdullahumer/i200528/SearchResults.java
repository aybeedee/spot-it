package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class SearchResults extends AppCompatActivity {

    ImageView back_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Spinner filterSpinner = findViewById(R.id.spinner_filter_dropdown);
        ArrayAdapter<CharSequence> filterSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.filters_array, R.layout.filter_spinner_dropdown_item);
        filterSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(filterSpinnerAdapter);

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