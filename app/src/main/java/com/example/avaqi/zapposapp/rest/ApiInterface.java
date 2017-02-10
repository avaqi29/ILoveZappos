package com.example.avaqi.zapposapp.rest;

import com.example.avaqi.zapposapp.model.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Avaqi on 2017/2/8.
 */

public interface ApiInterface {
    @GET("/Search")
    Call<ProductResponse> getTopRatedMovies(@Query("term") String term, @Query("key") String key);
}
