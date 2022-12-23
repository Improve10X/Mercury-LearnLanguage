package com.example.learnlanguage.videos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnlanguage.R;
import com.example.learnlanguage.databinding.VideoItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> videos;
    private OnItemActionListener onItemActionListener;

    void setData(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VideoItemBinding binding = VideoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(binding);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        if (video.videoImageUrl != null && video.videoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.videoImageUrl).into(holder.binding.videoImg);
        }
        if (video.channelLogoImageUrl != null && video.channelLogoImageUrl.isEmpty() == false) {
            Picasso.get().load(video.channelLogoImageUrl).into(holder.binding.channelLogoImg);
        }
        holder.binding.videoTitleTxt.setText(video.title);
        holder.binding.channelNameTxt.setText(video.channelName);
        holder.binding.viewsTxt.setText(video.views);
        holder.binding.uploadedTimeTxt.setText(video.uploadedTime);
        holder.binding.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onDelete(video.id);
        });
        holder.binding.editBtn.setOnClickListener(view -> {
            onItemActionListener.onEdit(video);
        });
        holder.binding.getRoot().setOnClickListener(view -> {
            onItemActionListener.onClicked(video);
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
