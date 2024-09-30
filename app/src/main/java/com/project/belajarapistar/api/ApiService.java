package com.project.belajarapistar.api;

import com.project.belajarapistar.data.model.StarResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("stars")
    Call<StarResponse> getStar(@Query("name") String name, @Query("X-Api-Key") String apiKey);
}
