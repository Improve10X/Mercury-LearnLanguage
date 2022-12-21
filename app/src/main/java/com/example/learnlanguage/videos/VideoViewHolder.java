package com.example.learnlanguage.videos;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnlanguage.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    ImageView videoImg;
    ImageView channelLogoImg;
    TextView videoTitleTxt;
    TextView channelNameTxt;
    TextView viewsTxt;
    TextView uploadedTimeTxt;
    ImageButton deleteBtn;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoImg = itemView.findViewById(R.id.video_img);
        channelLogoImg = itemView.findViewById(R.id.channel_logo_img);
        videoTitleTxt = itemView.findViewById(R.id.video_title_txt);
        channelNameTxt = itemView.findViewById(R.id.channel_name_txt);
        viewsTxt = itemView.findViewById(R.id.views_txt);
        uploadedTimeTxt = itemView.findViewById(R.id.uploaded_time_txt);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}
