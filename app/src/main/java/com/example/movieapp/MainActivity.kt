package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_details.view.*
import kotlinx.android.synthetic.main.moviecardview.view.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity(){
    var currentPage=1
    lateinit var moviesAdapter: MoviesAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesAdapter= MoviesAdapter(mutableListOf() )
        layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        moviesRecyclerView.adapter=moviesAdapter
        moviesRecyclerView.layoutManager=layoutManager
        getPopularMovies()
    }

    fun getPopularMovies()
    {
       Log.d("PopularMovies","here")
        MoviesClient.seekPopularMovies(currentPage,::onSuccess,::onError)
    }

    private fun onError()
    {
        Toast.makeText(this,"Failed to get movies",Toast.LENGTH_SHORT).show()
    }

    private fun onSuccess(list: MutableList<Movies>)
    {
        moviesAdapter.append(list)
        attachOnScrollListener()
    }

    fun attachOnScrollListener()
    {
        moviesRecyclerView.addOnScrollListener(object:RecyclerView.OnScrollListener()
        {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItems=layoutManager.itemCount
                val visibleItems=layoutManager.childCount
                val firstVisibleItem=layoutManager.findLastVisibleItemPosition()
                if (firstVisibleItem+visibleItems>=totalItems/2)
                {
                    moviesRecyclerView.removeOnScrollListener(this)
                    currentPage++
                    getPopularMovies()
                }
            }
        })
    }



       fun onMovieClicked(view: View) {
        var position=layoutManager.getPosition(view)
        var movie=moviesAdapter.movieslist!![position]
        val intent=Intent(this,MovieDetails::class.java)
        var extras=Bundle()
        extras.putString("summary",movie.overview)
        extras.putString("poster",movie.backdropPath)
        extras.putString("title",movie.title)
        extras.putFloat("popularity",movie.popularity)
        extras.putFloat("voteCount",movie.voteCount)
        extras.putString("langauge",movie.overiginalLanguage)
        intent.putExtras(extras)
        startActivity(intent)
    }

}




