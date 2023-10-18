package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PostItem extends AppCompatActivity {

    ImageView close_post_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_item);

//        Date date = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        Log.d("calYear", String.valueOf(calendar.get(Calendar.YEAR)));
        Log.d("calMonth", calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH));
        Log.d("calDay", String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));

        close_post_item = findViewById(R.id.image_close_post_item);

        Spinner citySpinner = findViewById(R.id.spinner_city_dropdown);
        ArrayAdapter<CharSequence> citySpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.cities_array, R.layout.spinner_dropdown_item);
        citySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(citySpinnerAdapter);

        close_post_item.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostItem.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}