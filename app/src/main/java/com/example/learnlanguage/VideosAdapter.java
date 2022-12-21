package com.example.learnlanguage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> videos;

    void setData(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        if (video.videoImageUrl != null && video.videoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.videoImageUrl).into(holder.videoImg);
        }
        if (video.channelLogoImageUrl != null && video.channelLogoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoImageUrl).into(holder.channelLogoImg);
        }
        holder.videoTitleTxt.setText(video.title);
        holder.channelNameTxt.setText(video.channelName);
        holder.viewsTxt.setText(video.views);
        holder.uploadedTimeTxt.setText(video.uploadedTime);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
