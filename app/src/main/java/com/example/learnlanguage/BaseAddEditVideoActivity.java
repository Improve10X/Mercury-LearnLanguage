package com.example.learnlanguage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditVideoActivity extends BaseActivity {

    protected EditText titleTxt;
    protected EditText videoImageUrlTxt;
    protected EditText channelNameTxt;
    protected EditText channelLogoImageUrlTxt;
    protected EditText viewsTxt;
    protected EditText uploadedTimeTxt;
    private Button addBtn;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit_video);
        getSupportActionBar().setTitle("Add Video");
        initViews();
        handleAddBtn();
    }

    private void initViews() {
        titleTxt = findViewById(R.id.title_txt);
        videoImageUrlTxt = findViewById(R.id.video_image_url_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        channelLogoImageUrlTxt = findViewById(R.id.channel_logo_img_url_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadedTimeTxt = findViewById(R.id.uploaded_time_txt);
        addBtn = findViewById(R.id.add_btn);
        updateBtn = findViewById(R.id.update_btn);
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