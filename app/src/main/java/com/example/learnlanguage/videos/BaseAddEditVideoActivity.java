package com.example.learnlanguage.videos;

import android.os.Bundle;
import android.widget.EditText;

import com.example.learnlanguage.BaseActivity;
import com.example.learnlanguage.R;

public class BaseAddEditVideoActivity extends BaseActivity {

    protected EditText titleTxt;
    protected EditText videoImageUrlTxt;
    protected EditText channelNameTxt;
    protected EditText channelLogoImageUrlTxt;
    protected EditText viewsTxt;
    protected EditText uploadedTimeTxt;
    protected EditText youtubeVideoIdTxt;

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
        youtubeVideoIdTxt = findViewById(R.id.youtube_video_id_txt);
    }
}