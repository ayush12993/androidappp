package com.ayushm.movielist.RequestManager;

import com.ayushm.movielist.model.Categories;
import com.ayushm.movielist.model.MoviesList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface APIInterface {
   @GET("player_api.php?")
   Call<List<Categories>> getCategoriesList(@Query("username") String username,
                                           @Query("password") String passowrd,
                                           @Query("action") String action);
   @GET("player_api.php?")
   Call<List<MoviesList>> getMoviesList(@Query("username") String username,
                                  @Query("password") String passowrd,
                                  @Query("action") String action);
}
