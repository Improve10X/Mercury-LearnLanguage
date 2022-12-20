package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

    private ArrayList<Video> videos;
    private RecyclerView videosRv;
    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        getSupportActionBar().setTitle("Videos");
        initViews();
        setupData();
        setupVideosAdapter();
        setupVideosRv();
    }

    private void initViews() {
        videosRv = findViewById(R.id.videos_rv);
    }

    private void setupData() {
        videos = new ArrayList<>();

        Video video1 = new Video();
        video1.title = "English Short Stories For Kids English Cartoon With English Subtitle 7";
        video1.imageUrl = "https://i.ytimg.com/an_webp/r2pEEkaFq8U/mqdefault_6s.webp?du=3000&sqp=CPXLhp0G&rs=AOn4CLADVtuxu9YSYGM8CsuwHtMifDlo4g";
        video1.chanelLogoImageUrl = "https://yt3.ggpht.com/ytc/AMLnZu_wfmAAKPIOXVPRnPkHSRrBvNUoOW50aNWyRioLjw=s48-c-k-c0x00ffffff-no-rj";
        video1.chanelName = "vesko stayn";
        video1.views = "5M views";
        video1.uploadTime = "6 years ago";
        videos.add(video1);
        videos.add(video1);
        videos.add(video1);
        videos.add(video1);
        videos.add(video1);
    }

    private void setupVideosRv() {
        videosRv.setLayoutManager(new LinearLayoutManager(this));
        videosRv.setAdapter(videosAdapter);
    }

    private void setupVideosAdapter() {
        videosAdapter = new VideosAdapter();
        videosAdapter.setData(videos);
    }
}