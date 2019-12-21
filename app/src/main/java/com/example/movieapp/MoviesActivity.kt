package com.example.movieapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movies__recycler_view.*

class MoviesActivity : AppCompatActivity(), OnMovieClickListener {
    override fun onMovieClicked(movieModel: MovieModel, position: Int) {
        Toast.makeText(this, movieModel.name + " in poistion " + position + " was clicked",
            Toast.LENGTH_SHORT).show()

    }

    private val movies: MutableList<MovieModel> = mutableListOf()

    private lateinit  var movie_Adapter : Movie_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        loadMovies()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        movies_rv_list.layoutManager = LinearLayoutManager(this@MoviesActivity)
        // Create Movies Adapter
        movie_Adapter = Movie_Adapter(
            context = this@MoviesActivity,
            movieClickListener = this@MoviesActivity
        )
        // Attach Adapter to RecyclerView
        movies_rv_list.adapter = movie_Adapter
        // Populate Adapter with data
        movie_Adapter.setData(movies)
    }

    private fun loadMovies() {
        movies.add(
            MovieModel(
                R.string.Deadpool2.toString(),
                R.drawable.deadpool2,
                R.string.Deadpool2_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.jurassic_world.toString(),
                R.drawable.jurassic_park,
                R.string.jurassic_world_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.avengers_infinity_war_title.toString(),
                R.drawable.avengers_infinity_war,
                R.string.avengers_infinity_war_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.black_panther.toString(),
                R.drawable.black_panther,
                R.string.black_panther_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.guardians_of_the_galaxy.toString(),
                R.drawable.guardians_of_the_galaxy,
                R.string.guardians_of_the_galaxy_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.interstellar.toString(),
                R.drawable.inter_stellar,
                R.string.interstellar_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.ocean8.toString(),
                R.drawable.ocean8,
                R.string.ocean8_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.the_first_purge.toString(),
                R.drawable.purge,
                R.string.the_first_purge_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.the_meg.toString(),
                R.drawable.the_meg,
                R.string.the_meg_overview.toString()
            )
        )
        movies.add(
            MovieModel(
                R.string.thor.toString(),
                R.drawable.thor_rangarok,
                R.string.thor_overview.toString()
            )
        )
    }

}