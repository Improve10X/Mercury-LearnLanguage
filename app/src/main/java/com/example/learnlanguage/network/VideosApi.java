package com.example.learnlanguage.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideosApi {

    public VideosService createCrudService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VideosService videosService = retrofit.create(VideosService.class);
        return videosService;
    }
}
