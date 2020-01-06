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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        //loadMovies()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        //val movies_rv_list = movies_rv_list as RecyclerView
        //val recycler_view = RecyclerView(this)
        movies_fragment_rcv.layoutManager = LinearLayoutManager(this@MoviesActivity) as RecyclerView.LayoutManager
        // Create Movies Adapter
        movie_Adapter = Movie_Adapter(
            context = this@MoviesActivity,
            movieClickListener = this@MoviesActivity
        )

            // Attach Adapter to RecyclerView
        movies_fragment_rcv.adapter = movie_Adapter
       // recycler_view.layoutManager = LinearLayoutManager(this@MoviesActivity)

        // Populate Adapter with data
        movie_Adapter.setData(movies)

       // val view_holder = movie_Adapter.onCreateViewHolder(recycler_view, recycler_view.layerType)
        //movie_Adapter.onBindViewHolder(view_holder, 0)
    }




}
