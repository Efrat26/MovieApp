package com.example.movieapp
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movies.*


class MainActivity : AppCompatActivity(), OnMovieClickListener {
    private val avengers_url = "https://www.youtube.com/watch?v=6ZfuNTqbHE8"

    private var movies: MutableList<MovieModel> = ArrayList()

    private lateinit var viewPager: ViewPager

    private var tabletFragmentContainer: FrameLayout? = null

    private lateinit var selectedMovieIndex : Integer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add movies recycler view
        movies = loadMovies()
        viewPager = findViewById(R.id.main_activity_pager)

        setSupportActionBar(findViewById(R.id.my_toolbar))

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.application_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean{
        when(item.toString())
        {
            getString(R.string.open_async_task) -> {
                val openSecondActivity = Intent(this, AsyncTaskActivity::class.java)
                startActivity(openSecondActivity)


            }
            getString(R.string.open_thread_handler) -> {
                val openSecondActivity = Intent(this, AsyncTaskActivity::class.java)
                startActivity(openSecondActivity)
            }
            else -> {

            }
        }

        return true
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

        selectedMovieIndex = Integer(movieIndex)

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
        if(selectedMovieIndex.toInt() >= 0) {
            webpage = Uri.parse(movies[selectedMovieIndex.toInt()].trailerLink)
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
                getString(R.string.jurassic_world_overview),
                getString(R.string.released_date),
                getString(R.string.jurassic_world_trailer_link),
                R.drawable.jurassic_park
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.Deadpool2),
                R.drawable.deadpool2,
                getString(R.string.Deadpool2_overview),
                getString(R.string.released_date),
                getString(R.string.deadpool2__trailer_link),
                R.drawable.deadpool2
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.avengers_infinity_war_title),
                R.drawable.avengers_infinity_war,
                getString(R.string.avengers_infinity_war_overview),
                getString(R.string.released_date),
                getString(R.string.avengers_infinty_wars_trailer_link),
                R.drawable.avengers_infinity_war_background
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.black_panther),
                R.drawable.black_panther,
                getString(R.string.black_panther_overview),
                getString(R.string.released_date),
                getString(R.string.black_panther_trailer_link),
                R.drawable.black_panther
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.guardians_of_the_galaxy),
                R.drawable.guardians_of_the_galaxy,
                getString(R.string.guardians_of_the_galaxy_overview),
                getString(R.string.released_date),
                getString(R.string.guardians_of_the_galaxy_trailer_link),
                R.drawable.guardians_of_the_galaxy
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.interstellar),
                R.drawable.inter_stellar,
                getString(R.string.interstellar_overview),
                getString(R.string.released_date),
                getString(R.string.interstellat_trailer_link),
                R.drawable.inter_stellar
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.ocean8),
                R.drawable.ocean8,
                getString(R.string.ocean8_overview),
                getString(R.string.released_date),
                getString(R.string.ocean8_trailer_link),
                R.drawable.ocean8
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.the_first_purge),
                R.drawable.purge,
                getString(R.string.the_first_purge_overview),
                getString(R.string.released_date),
                getString(R.string.purge_trailer_link),
                R.drawable.purge
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.the_meg),
                R.drawable.the_meg,
                getString(R.string.released_date),
                getString(R.string.released),
                getString(R.string.meg_trailer_link),
                R.drawable.the_meg
            )
        )
        movies.add(
            MovieModel(
                getString(R.string.thor),
                R.drawable.thor_rangarok,
                getString(R.string.thor_overview),
                getString(R.string.released_date),
                getString(R.string.thor_trailer_link),
                R.drawable.thor_rangarok
            )
        )

        return movies
    }

}