package com.abdullahumer.i200528;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class DirectMessage extends AppCompatActivity {

    ImageView back_chat;
    ScrollView chat_messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_message);

        back_chat = findViewById(R.id.image_back_chat);
        chat_messages = findViewById(R.id.scroll_chat_messages);

        chat_messages.postDelayed(new Runnable() {

            @Override
            public void run() {

                chat_messages.fullScroll(ScrollView.FOCUS_DOWN);
            }
        },0);

        back_chat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DirectMessage.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}