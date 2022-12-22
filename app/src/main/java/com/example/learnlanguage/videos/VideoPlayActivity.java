package com.example.learnlanguage.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learnlanguage.R;

public class VideoPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        getSupportActionBar().setTitle("Play Video");
    }
}