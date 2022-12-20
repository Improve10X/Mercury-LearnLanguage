package com.example.learnlanguage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    ImageView videoImg;
    ImageView chanelLogoImg;
    TextView videoTitleTxt;
    TextView chanelNameTxt;
    TextView viewsTxt;
    TextView updateTimeTxt;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoImg = itemView.findViewById(R.id.video_img);
        chanelLogoImg = itemView.findViewById(R.id.chanel_logo_img);
        videoTitleTxt = itemView.findViewById(R.id.video_title_txt);
        chanelNameTxt = itemView.findViewById(R.id.chanel_name_txt);
        viewsTxt = itemView.findViewById(R.id.views_txt);
        updateTimeTxt = itemView.findViewById(R.id.update_time_txt);
    }
}
