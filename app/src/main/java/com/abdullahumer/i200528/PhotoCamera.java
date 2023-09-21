package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PhotoCamera extends AppCompatActivity {

    ImageView back_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_camera);

        back_camera = findViewById(R.id.image_back_camera);

        back_camera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PhotoCamera.this, DirectMessage.class);
                startActivity(intent);
            }
        });
    }
}