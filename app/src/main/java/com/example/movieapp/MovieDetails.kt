package com.example.movieapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.moviecardview.*
import kotlinx.android.synthetic.main.moviecardview.view.*

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
       val summary=intent.getStringExtra("summary")
        movieSummary.text=summary
        val poster=intent.getStringExtra("poster")
        val post=Glide.with(this).load("https://image.tmdb.org/t/p/w342${poster}").transform(
            CenterCrop()).into(moviePost)
        val title=intent.getStringExtra("title")
        movieTitle2.text=title
        val popularity=intent.getFloatExtra("popularity",0.0F)
        moviePopularityCount.text=popularity.toString()
        val vote=intent.getFloatExtra("voteCount",0.0F)
        movieVoteCount.text=vote.toString()
        val langauge=intent.getStringExtra("langauge")
        movieLangaugeInput.text=langauge
    }
}