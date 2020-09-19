package com.example.movieapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesClient {
    val BaseURL="https://api.themoviedb.org/3/"

    val service:APIServices
    init {
        val retrofit=Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).build()
        service=retrofit.create(APIServices::class.java)
    }

    fun seekPopularMovies(page:Int=1,onSuccess:(moviesList:MutableList<Movies>)->Unit,onError:()->Unit)
    {
        service.getPopularMovies(pageNumber = page).enqueue(object :Callback<MoviesResponse>
        {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
               onError.invoke()
            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if (response.isSuccessful)
                {
                    if (response.body()!=null)
                    {
                        onSuccess.invoke(response.body()!!.movies)
                    }
                    else
                    {
                        onError.invoke()
                    }
                }
            }
        })
    }


}