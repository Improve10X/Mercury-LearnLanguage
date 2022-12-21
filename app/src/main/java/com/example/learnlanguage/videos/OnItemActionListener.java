package com.example.learnlanguage.videos;

import com.example.learnlanguage.videos.Video;

public interface OnItemActionListener {

    void onDelete(String id);

    void onEdit(Video video);
}
