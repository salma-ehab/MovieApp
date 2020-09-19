package com.example.movieapp

import com.google.gson.annotations.SerializedName

data class MoviesResponse (
    @SerializedName("page") val currentPage:Int,
    @SerializedName("total_Pages") val  totalPages:Int,
    @SerializedName("results") val movies: MutableList<Movies>
)
