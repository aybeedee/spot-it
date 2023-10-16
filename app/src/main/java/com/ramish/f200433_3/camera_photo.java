package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class camera_photo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_photo);
    }
    public void OpenVideo(View view){
        Intent intent=new Intent(
                camera_photo.this,
                camera_video.class);
        startActivity(intent);
    }
}