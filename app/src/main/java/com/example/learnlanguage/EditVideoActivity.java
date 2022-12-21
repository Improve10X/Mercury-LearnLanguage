package com.example.learnlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideoActivity {

    private Button updateBtn;
    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        getSupportActionBar().setTitle("Edit Video");
        if (getIntent().hasExtra(Constants.KEY_VIDEO)) {
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
            updateBtn.setVisibility(View.VISIBLE);
            handleUpdateBtn();
            showData();
        }
    }

    private void showData() {
        titleTxt.setText(video.title);
        videoImageUrlTxt.setText(video.videoImageUrl);
        channelNameTxt.setText(video.channelName);
        channelLogoImageUrlTxt.setText(video.channelLogoImageUrl);
        viewsTxt.setText(video.views);
        uploadedTimeTxt.setText(video.uploadedTime);
    }

    private void initViews() {
        updateBtn = findViewById(R.id.update_btn);
    }

    private void handleUpdateBtn() {
        updateBtn.setOnClickListener(view -> {
            String title = titleTxt.getText().toString();
            String videoImageUrl = videoImageUrlTxt.getText().toString();
            String channelName = channelNameTxt.getText().toString();
            String channelLogoImageUrl = channelLogoImageUrlTxt.getText().toString();
            String views = viewsTxt.getText().toString();
            String uploadedTime = uploadedTimeTxt.getText().toString();
            updateVideo(video.id, title, videoImageUrl, channelName, channelLogoImageUrl, views, uploadedTime);
        });
    }

    private void updateVideo(String id, String titleText, String videoImageUrl, String channelName, String channelLogoImageUrl, String views, String uploadedTime) {
        Video updatedVideo = new Video();
        updatedVideo.title = titleText;
        updatedVideo.videoImageUrl = videoImageUrl;
        updatedVideo.channelName = channelName;
        updatedVideo.channelLogoImageUrl = channelLogoImageUrl;
        updatedVideo.views = views;
        updatedVideo.uploadedTime = uploadedTime;

        Call<Void> call = videosService.updateVideo(id, updatedVideo);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                finish();
                showToast("Successfully Video Updated");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed  Update Video");
            }
        });
    }
}
