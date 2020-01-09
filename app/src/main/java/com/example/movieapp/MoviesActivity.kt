package com.example.movieapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesActivity : AppCompatActivity(), OnMovieClickListener {





    override fun onMovieClicked(movieModel: MovieModel) {
       // Toast.makeText(this, movieModel.name + " in position " + position + " was clicked",
       //Toast.LENGTH_SHORT).show()
        Toast.makeText(this, movieModel.name, Toast.LENGTH_SHORT).show()
    }

    private val movies: MutableList<MovieModel> = mutableListOf()

    private lateinit  var movie_Adapter : Movie_Adapter

    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesFragment = MoviesFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.activity_main_frame, moviesFragment)
            .commit()
    }





}
