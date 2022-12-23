package com.example.learnlanguage.videos;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnlanguage.R;
import com.example.learnlanguage.databinding.VideoItemBinding;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    VideoItemBinding binding;

    public VideoViewHolder(VideoItemBinding videoItemBinding) {
        super(videoItemBinding.getRoot());
        binding = videoItemBinding;
    }
}
