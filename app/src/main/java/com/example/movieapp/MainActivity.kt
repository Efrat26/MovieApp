package com.example.movieapp
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.movie_details.*

class MainActivity : AppCompatActivity(), OnMovieClickListener {
    private val avengers_url = "https://www.youtube.com/watch?v=6ZfuNTqbHE8"

    private var movies: MutableList<MovieModel> = ArrayList()

    private lateinit var viewPager: ViewPager

    private var tabletFragmentContainer: FrameLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movies = loadMovies()
        viewPager = findViewById(R.id.main_activity_pager)

        tabletFragmentContainer = findViewById(R.id.activity_main_tablet_frame)

        val moviesFragment: MoviesFragment =
        if (savedInstanceState == null && tabletFragmentContainer == null) {
            MoviesFragment().also {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.activity_main_frame, it, MoviesFragment.TAG)
                    .commit()
            }
        } else if(savedInstanceState == null && tabletFragmentContainer != null){
            MoviesFragment().also {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.activity_main_tablet_frame, it, MoviesFragment.TAG)
                    .commit()
            }
        } else {
            supportFragmentManager.findFragmentByTag(MoviesFragment.TAG) as MoviesFragment
        }
        moviesFragment.setMoviesList(movies)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun ManageConstraints(){
        val set = ConstraintSet()
        set.constrainPercentWidth(movies_fragment_rcv.id,0.4f)
        set.applyTo(main_activity_constraintlayout)
    }

    override fun onMovieClicked(movie: MovieModel){
        val movieIndex = movies.indexOfFirst{w -> w.name == movie.name}

        val fragments = movies.map {
            DetailsFragment.newInstance(it)
        }

        val adapter = PagerAdapter(supportFragmentManager, fragments)
        viewPager.adapter = adapter

        viewPager.setCurrentItem(movieIndex, false)

        val frag = supportFragmentManager.findFragmentByTag(movies[movieIndex].name)

        ManageConstraints()
        frag?.let {
            if(tabletFragmentContainer == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_activity_pager, it)
                    .addToBackStack(null).commit()
            } else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.activity_main_tablet_frame, it)
            }
        }


    }

    fun linkToYoutube(view : View){
        var webpage : Uri = Uri.EMPTY
        if(view.id == details_fragment_trailer_btn.id) {
            webpage = Uri.parse(avengers_url)
        }
        if(webpage != Uri.EMPTY) {
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

    fun loadMovies() : MutableList<MovieModel>{

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

/*
    override fun onMovieClicked(movie: MovieModel) {
        val detailsFragment = DetailsFragment.newInstance(movie)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_activity_pager, detailsFragment)
            .commit()
    }*/

/*
       val moviesFragment: MoviesFragment=
           if (savedInstanceState == null) {
               MoviesFragment.newInstance() also {
                   supportFragmentManager
                       .beginTransaction()
                       .add(R.id.activity_main_frame, it, MoviesFragment.TAG)
                       .commit()
               }
           }else {
               supportFragmentManager.findFragmentByTag(MoviesFragment.TAG) as MoviesFragment
           }


       val movies = moviesFragment.loadMovies()

       val fragments = movies.map {
           DetailsFragment.newInstance(it)
       }

       val adapter = PagerAdapter(supportFragmentManager, fragments)
       viewPager.adapter = adapter
*/