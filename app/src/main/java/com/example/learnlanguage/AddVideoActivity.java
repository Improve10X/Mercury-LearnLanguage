package com.example.learnlanguage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            String title = titleTxt.getText().toString();
            String videoImageUrl = videoImageUrlTxt.getText().toString();
            String channelName = channelNameTxt.getText().toString();
            String channelLogoImageUrl = channelLogoImageUrlTxt.getText().toString();
            String views = viewsTxt.getText().toString();
            String uploadedTime = uploadedTimeTxt.getText().toString();
            addVideo(title, videoImageUrl, channelName, channelLogoImageUrl, views, uploadedTime);
        });
    }

    private void addVideo(String titleText, String videoImageUrl, String channelName, String channelLogoImageUrl, String views, String uploadedTime) {
        Video video = new Video();
        video.title = titleText;
        video.videoImageUrl = videoImageUrl;
        video.channelName = channelName;
        video.channelLogoImageUrl = channelLogoImageUrl;
        video.views = views;
        video.uploadedTime = uploadedTime;

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
