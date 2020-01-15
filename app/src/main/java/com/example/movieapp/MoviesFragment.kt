package com.example.movieapp
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class MoviesFragment : Fragment(), OnMovieClickListener  {

    companion object {
        val TAG = MoviesFragment::class.simpleName

        private val ARG_MOVIE = "MovieModel-data"

        fun newInstance(movieModel: MovieModel): MoviesFragment {
            val fragment = MoviesFragment()
            val args = Bundle()
            args.putParcelable(ARG_MOVIE, movieModel)
            fragment.arguments = args
            return fragment
        }
    }



    private val movies: MutableList<MovieModel> = ArrayList()
    private lateinit var moviesAdapter: Movie_Adapter

    private lateinit var moviesRcv: RecyclerView


    private var listener: OnMovieClickListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        }
    }


    fun MoviesFragment(){

    }
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

            moviesRcv.layoutManager = LinearLayoutManager(it)
            // Populate Adapter with data
            moviesAdapter.setData(movies)
        }
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onMovieClicked(movie: MovieModel) {
        listener?.onMovieClicked(movie)
    }


    fun loadMovies() : List<MovieModel>{

        movies.add(
            MovieModel(
                getString(R.string.jurassic_world),
                R.drawable.jurassic_park,
                getString(R.string.jurassic_world_overview)
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.Deadpool2),
                R.drawable.deadpool2,
                getString(R.string.Deadpool2_overview)
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

        return movies
    }

}