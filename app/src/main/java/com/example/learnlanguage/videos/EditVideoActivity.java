package com.example.learnlanguage.videos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnlanguage.Constants;
import com.example.learnlanguage.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditVideoActivity extends BaseAddEditVideoActivity {

    private Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Edit Video");
        if (getIntent().hasExtra(Constants.KEY_VIDEO)) {
            video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
            binding.updateBtn.setVisibility(View.VISIBLE);
            handleUpdateBtn();
            showData();
        }
    }

    private void showData() {
        binding.titleTxt.setText(video.title);
        binding.videoImageUrlTxt.setText(video.videoImageUrl);
        binding.channelNameTxt.setText(video.channelName);
        binding.channelLogoImgUrlTxt.setText(video.channelLogoImageUrl);
        binding.viewsTxt.setText(video.views);
        binding.uploadedTimeTxt.setText(video.uploadedTime);
        binding.youtubeVideoIdTxt.setText(video.youtubePlayerId);
    }

    private void handleUpdateBtn() {
        binding.updateBtn.setOnClickListener(view -> {
            String title = binding.titleTxt.getText().toString();
            String videoImageUrl = binding.videoImageUrlTxt.getText().toString();
            String channelName = binding.channelNameTxt.getText().toString();
            String channelLogoImageUrl = binding.channelLogoImgUrlTxt.getText().toString();
            String views = binding.viewsTxt.getText().toString();
            String uploadedTime = binding.uploadedTimeTxt.getText().toString();
            String youtubeVideoId = binding.youtubeVideoIdTxt.getText().toString();
            updateVideo(video.id, title, videoImageUrl, channelName, channelLogoImageUrl, views, uploadedTime, youtubeVideoId);
        });
    }

    private void updateVideo(String id, String titleText, String videoImageUrl, String channelName, String channelLogoImageUrl, String views, String uploadedTime, String youtubeVideoId) {
        Video updatedVideo = new Video();
        updatedVideo.title = titleText;
        updatedVideo.videoImageUrl = videoImageUrl;
        updatedVideo.channelName = channelName;
        updatedVideo.channelLogoImageUrl = channelLogoImageUrl;
        updatedVideo.views = views;
        updatedVideo.uploadedTime = uploadedTime;
        updatedVideo.youtubePlayerId = youtubeVideoId;

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
