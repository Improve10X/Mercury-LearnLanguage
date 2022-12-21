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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit_video);
        initViews();
    }

    private void initViews() {
        titleTxt = findViewById(R.id.title_txt);
        videoImageUrlTxt = findViewById(R.id.video_image_url_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        channelLogoImageUrlTxt = findViewById(R.id.channel_logo_img_url_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadedTimeTxt = findViewById(R.id.uploaded_time_txt);
    }
}