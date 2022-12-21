package com.example.learnlanguage;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("_id")
    public String id;
    public String title;
    public String imageUrl;
    public String chanelLogoImageUrl;
    public String chanelName;
    public String views;
    public String uploadedTime;
}
