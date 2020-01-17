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



    private var movies: MutableList<MovieModel> = ArrayList()
    private lateinit var moviesAdapter: Movie_Adapter

    private lateinit var moviesRcv: RecyclerView


    private var listener: OnMovieClickListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        moviesRcv = view.findViewById(R.id.movies_fragment_rcv)
        //loadMovies()
        initRecyclerView()
        return view
    }

    public fun setMoviesList(moviesList : MutableList<MovieModel>){
        movies = moviesList
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




}