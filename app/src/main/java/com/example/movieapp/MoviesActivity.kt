package com.example.movieapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movies__recycler_view.*


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
        setContentView(R.layout.activity_movies__recycler_view)
        loadMovies()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        //val movies_rv_list = movies_rv_list as RecyclerView
        //val recycler_view = RecyclerView(this)
        movies_rv_list.layoutManager = LinearLayoutManager(this@MoviesActivity) as RecyclerView.LayoutManager
        // Create Movies Adapter
        movie_Adapter = Movie_Adapter(
            context = this@MoviesActivity,
            movieClickListener = this@MoviesActivity
        )

            // Attach Adapter to RecyclerView
        movies_rv_list.adapter = movie_Adapter
       // recycler_view.layoutManager = LinearLayoutManager(this@MoviesActivity)

        // Populate Adapter with data
        movie_Adapter.setData(movies)

       // val view_holder = movie_Adapter.onCreateViewHolder(recycler_view, recycler_view.layerType)
        //movie_Adapter.onBindViewHolder(view_holder, 0)
    }


    private fun loadMovies() {
        movies.add(
            MovieModel(
                getString(R.string.Deadpool2),
                R.drawable.deadpool2,
                getString(R.string.Deadpool2_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.jurassic_world),
                R.drawable.jurassic_park,
                getString(R.string.jurassic_world_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.avengers_infinity_war_title),
                R.drawable.avengers_infinity_war,
                getString(R.string.avengers_infinity_war_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.black_panther),
                R.drawable.black_panther,
                getString(R.string.black_panther_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.guardians_of_the_galaxy),
                R.drawable.guardians_of_the_galaxy,
                getString(R.string.guardians_of_the_galaxy_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.interstellar),
                R.drawable.inter_stellar,
                getString(R.string.interstellar_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.ocean8),
                R.drawable.ocean8,
                getString(R.string.ocean8_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.the_first_purge),
                R.drawable.purge,
                getString(R.string.the_first_purge_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.the_meg),
                R.drawable.the_meg,
                getString(R.string.the_meg_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.thor),
                R.drawable.thor_rangarok,
                getString(R.string.thor_overview)
            )
        )
    }

}
