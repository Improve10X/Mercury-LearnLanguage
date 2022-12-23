package com.example.learnlanguage.videos;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnlanguage.Constants;
import com.example.learnlanguage.R;
import com.example.learnlanguage.databinding.ActivityVideoPlayBinding;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class VideoPlayActivity extends YouTubeBaseActivity {

    private Video video;
    private ActivityVideoPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        video = (Video) getIntent().getSerializableExtra(Constants.KEY_VIDEO);
        showData();
        setupYouTubePlayer();
    }

    private void showData() {
        if (video.channelLogoImageUrl != null && video.channelLogoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoImageUrl).into(binding.channelLogoImg);
        }
        binding.videoTitleTxt.setText(video.title);
        binding.channelNameTxt.setText(video.channelName);
        binding.viewsTxt.setText(video.views);
        binding.uploadedTimeTxt.setText(video.uploadedTime);
    }

    private void setupYouTubePlayer() {
        binding.youtubePlayerView.initialize(Constants.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
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