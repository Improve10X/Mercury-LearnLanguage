package com.example.learnlanguage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CrudService {

    @GET(Constants.VIDEOS_END_POINT)
    Call<List<Video>> fetchVideos();

    @POST(Constants.VIDEOS_END_POINT)
    Call<Video> createVideo(@Body Video video);
}
