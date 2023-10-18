package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class DirectMessage extends AppCompatActivity {

    ImageView back_chat, take_picture, video_call, voice_call;
    ScrollView chat_messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_message);

        back_chat = findViewById(R.id.image_back_chat);
        take_picture = findViewById(R.id.image_take_picture);
        video_call = findViewById(R.id.image_video_call);
        voice_call = findViewById(R.id.image_voice_call);
        chat_messages = findViewById(R.id.scroll_chat_messages);

        back_chat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DirectMessage.this, MainActivity.class);
                startActivity(intent);

            }
        });

        take_picture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DirectMessage.this, PhotoCamera.class);
                startActivity(intent);

            }
        });

        video_call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DirectMessage.this, VideoCall.class);
                startActivity(intent);

            }
        });

        voice_call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DirectMessage.this, VoiceCall.class);
                startActivity(intent);

            }
        });

        chat_messages.postDelayed(new Runnable() {

            @Override
            public void run() {

                chat_messages.fullScroll(ScrollView.FOCUS_DOWN);
            }
        },0);
    }
}