package com.ayushm.movielist.task2.RequestManager;

import com.ayushm.movielist.task2.model.Categories;
import com.ayushm.movielist.task2.model.MoviesList;
import retrofit2.Call;
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
