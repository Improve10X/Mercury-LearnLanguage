package com.example.learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CrudService {

    @GET(Constants.VIDEOS_END_POINT)
    Call<List<Video>> fetchVideos();
}
