package com.example.learnlanguage.videos;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnlanguage.Constants;
import com.example.learnlanguage.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class VideoPlayActivity extends YouTubeBaseActivity {

    private Video video;
    private YouTubePlayerView youTubePlayerView;
    private ImageView channelLogoImg;
    private TextView videoTitleTxt;
    private TextView channelNameTxt;
    private TextView viewsTxt;
    private TextView uploadedTimeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        initViews();
        video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
        showData();
        setupYouTubePlayer();
    }

    private void showData() {
        if (video.channelLogoImageUrl != null && video.channelLogoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoImageUrl).into(channelLogoImg);
        }
        videoTitleTxt.setText(video.title);
        channelNameTxt.setText(video.channelName);
        viewsTxt.setText(video.views);
        uploadedTimeTxt.setText(video.uploadedTime);
    }

    private void initViews() {
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        channelLogoImg = findViewById(R.id.channel_logo_img);
        videoTitleTxt = findViewById(R.id.video_title_txt);
        channelNameTxt = findViewById(R.id.channel_name_txt);
        viewsTxt = findViewById(R.id.views_txt);
        uploadedTimeTxt = findViewById(R.id.uploaded_time_txt);
    }

    private void setupYouTubePlayer() {
        youTubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(video.youtubePlayerId);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(VideoPlayActivity.this, "Failed to initialized youtube player", Toast.LENGTH_SHORT).show();
            }
        });
    }
}