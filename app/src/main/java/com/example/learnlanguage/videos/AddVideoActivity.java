package com.example.learnlanguage.videos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnlanguage.R;
import com.example.learnlanguage.videos.BaseAddEditVideoActivity;
import com.example.learnlanguage.videos.Video;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVideoActivity extends BaseAddEditVideoActivity {

    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Video");
        initViews();
        addBtn.setVisibility(View.VISIBLE);
        handleAddBtn();
    }

    private void initViews() {
        addBtn = findViewById(R.id.add_btn);
    }

    private void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            String title = binding.titleTxt.getText().toString();
            String videoImageUrl = binding.videoImageUrlTxt.getText().toString();
            String channelName = binding.channelNameTxt.getText().toString();
            String channelLogoImageUrl = binding.channelLogoImgUrlTxt.getText().toString();
            String views = binding.viewsTxt.getText().toString();
            String uploadedTime = binding.uploadedTimeTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
            addVideo(title, videoImageUrl, channelName, channelLogoImageUrl, views, uploadedTime, youtubeVideoId);
        });
    }

    private void addVideo(String titleText, String videoImageUrl, String channelName, String channelLogoImageUrl, String views, String uploadedTime, String youtubeVideoId) {
        Video video = new Video();
        video.title = titleText;
        video.videoImageUrl = videoImageUrl;
        video.channelName = channelName;
        video.channelLogoImageUrl = channelLogoImageUrl;
        video.views = views;
        video.uploadedTime = uploadedTime;
        video.youtubePlayerId = youtubeVideoId;

        Call<Video> call = videosService.createVideo(video);
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                showToast("Successfully Video Added");
                finish();
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                showToast("Failed to Add Video");
            }
        });
    }
}
