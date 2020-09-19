package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.activity_movie_details.view.*
import kotlinx.android.synthetic.main.moviecardview.view.*

class MoviesAdapter( var movieslist:MutableList<Movies>?) :RecyclerView.Adapter <MoviesAdapter.MyViewHolder>(){

    class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
     fun Bind(movies: Movies)
     {
         itemView.movieTitle.text=movies.title
         itemView.movieReleaseDate.text=movies.releaseDate
         itemView.movieRating.text=movies.rating.toString()
         Glide.with(itemView).load("https://image.tmdb.org/t/p/w342${movies.posterPath}").transform(
             CenterCrop()).into(itemView.moviePoster)
     }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.moviecardview,parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movie=movieslist!![position]
        holder.Bind(movie)
    }

    override fun getItemCount():Int =movieslist!!.size

    fun append(movies: List<Movies>)
    {
        this.movieslist!!.addAll(movies)
        notifyItemRangeInserted(this.movieslist!!.size,movieslist!!.size-1)
    }

}