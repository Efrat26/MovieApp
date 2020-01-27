package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {



    private lateinit var posterImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var releaseDateText: TextView
    private lateinit var trailerButton: Button
    private lateinit var overviewText: TextView
    private lateinit var backgroundImage: ImageView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.movie_details, container, false)
        val movie: MovieModel? = arguments?.getParcelable(MOVIE_BUNDLE_KEY)
        initViews(view)
        movie?.let(::loadMovie)
        return view
    }

    private fun initViews(view: View) {
        posterImage = view.findViewById(R.id.details_fragment_poster)
        titleText = view.findViewById(R.id.details_fragment_title)
        releaseDateText = view.findViewById(R.id.details_fragment_release_date)
        trailerButton = view.findViewById(R.id.details_fragment_trailer_btn)
        overviewText = view.findViewById(R.id.details_fragment_overview_text)
        backgroundImage = view.findViewById(R.id.movie_details_poster)
    }

    companion object {
        var TAG = "Deadpool 2"::class.simpleName
        private const val MOVIE_BUNDLE_KEY = "unique_movie_key"

        fun newInstance(movie: MovieModel): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            DetailsFragment.TAG = movie.name
            args.putParcelable(MOVIE_BUNDLE_KEY, movie)
            fragment.arguments = args
            return fragment
        }
    }

    fun loadMovie(movie: MovieModel) {
        overviewText.text = movie.overview
        posterImage.setImageResource(movie.imageRes)
        titleText.text = movie.name
        releaseDateText.text = movie.releaseDate
        backgroundImage.setImageResource(movie.backImageRes)

    }

}