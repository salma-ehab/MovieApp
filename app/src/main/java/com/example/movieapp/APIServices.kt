package com.example.movieapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServices {
    @GET("movie/popular")

    fun getPopularMovies(@Query("api_key")apiKey:String="9e43c0bafdbfa5784a19c91dadfc2b88",@Query("page")pageNumber:Int=1)
    :Call<MoviesResponse>
}