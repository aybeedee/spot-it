package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class camera_video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_video);
    }
    public void OpenPhoto(View view){
        Intent intent=new Intent(
                camera_video.this,
                camera_photo.class);
        startActivity(intent);
    }
}