package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class chatting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
    }
    public void OpenCamera(View view){
        Intent intent=new Intent(
                chatting.this,
                camera_photo.class);
        startActivity(intent);
    }
    public void AudioCall(View view){
        Intent intent=new Intent(
                chatting.this,
                audio_call.class);
        startActivity(intent);
    }
    public void VideoCall(View view){
        Intent intent=new Intent(
                chatting.this,
                videocall.class);
        startActivity(intent);
    }

}