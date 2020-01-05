package com.example.movieapp


import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MoviesFragment : Fragment(), OnMovieClickListener  {

    private val movies: MutableList<MovieModel> = ArrayList()
    private lateinit var moviesAdapter: Movie_Adapter

    private lateinit var moviesRcv: RecyclerView
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        moviesRcv = view.findViewById(R.id.movies_fragment_rcv)

        loadMovies()

        initRecyclerView()

        return view
    }

    private fun initRecyclerView() {
        context?.let {
            // Create Movies Adapter
            moviesAdapter = Movie_Adapter(it, this@MoviesFragment)

            // Attach Adapter to RecyclerView
            moviesRcv.adapter = moviesAdapter

            // Populate Adapter with data
            moviesAdapter.setData(movies)
        }
    }


    override fun onMovieClicked(movieModel: MovieModel) {
        // Toast.makeText(this, movieModel.name + " in position " + position + " was clicked",
        //Toast.LENGTH_SHORT).show()
       // Toast.makeText(this, movieModel.name, Toast.LENGTH_SHORT).show()
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