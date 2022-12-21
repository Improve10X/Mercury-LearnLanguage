package com.example.learnlanguage;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learnlanguage.network.VideosApi;
import com.example.learnlanguage.network.VideosService;

public class BaseActivity extends AppCompatActivity {

    protected VideosService videosService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupApiService();
        log("onCreate Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume Called");
    }

    private void log(String message) {
        Log.i(this.getClass().getSimpleName(), message);
    }

    private void setupApiService() {
        VideosApi videosApi = new VideosApi();
        videosService = videosApi.createCrudService();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
