package com.example.learnlanguage.videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnlanguage.BaseActivity;
import com.example.learnlanguage.Constants;
import com.example.learnlanguage.R;
import com.squareup.picasso.Picasso;

public class VideoPlayActivity extends BaseActivity {

    private Video video;
    private ImageView videoImg;
    private ImageView channelLogoImg;
    private TextView videoTitleTxt;
    private TextView channelNameTxt;
    private TextView viewsTxt;
    private TextView uploadedTimeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        getSupportActionBar().setTitle("Play Video");
        initViews();
        video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
        showData();
    }

    private void showData() {
        if (video.videoImageUrl != null && video.videoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.videoImageUrl).into(videoImg);
        }
        if (video.channelLogoImageUrl != null && video.channelLogoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoImageUrl).into(channelLogoImg);
        }
        videoTitleTxt.setText(video.title);
        channelNameTxt.setText(video.channelName);
        viewsTxt.setText(video.views);
        uploadedTimeTxt.setText(video.uploadedTime);
    }

    private void initViews() {
        videoImg = findViewById(R.id.video_img);
        channelLogoImg = findViewById(R.id.channel_logo_img);
        videoTitleTxt = findViewById(R.id.video_title_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadedTimeTxt = findViewById(R.id.uploaded_time_txt);
    }
}