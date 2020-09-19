package com.example.movieapp

import com.google.gson.annotations.SerializedName

data class Movies (
  @SerializedName("id" )val id:Long,
  @SerializedName("title") val title:String,
  @SerializedName("release_date") val releaseDate:String,
  @SerializedName("vote_average")val rating:Float,
  @SerializedName("overview") val overview:String,
  @SerializedName("poster_path") val posterPath:String,
  @SerializedName("backdrop_path") val backdropPath:String,
  @SerializedName("popularity")val popularity:Float,
  @SerializedName("vote_count")val voteCount:Float,
  @SerializedName("original_language") val overiginalLanguage:String
  )