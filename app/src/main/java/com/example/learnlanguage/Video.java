package com.example.learnlanguage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Video implements Serializable {

    @SerializedName("_id")
    public String id;
    public String title;
    public String videoImageUrl;
    public String channelLogoImageUrl;
    public String channelName;
    public String views;
    public String uploadedTime;
}
