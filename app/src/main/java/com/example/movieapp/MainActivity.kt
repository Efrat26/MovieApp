package com.example.movieapp
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.movie_details.*

class MainActivity : AppCompatActivity(), OnMovieClickListener{
    private val avengers_url = "https://www.youtube.com/watch?v=6ZfuNTqbHE8"


    override protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager = findViewById(R.id.main_activity_pager)

        val moviesFragment: MoviesFragment=
            if (savedInstanceState == null) {
                MoviesFragment().also {
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

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onMovieClicked(movie: MovieModel) {
        val detailsFragment = DetailsFragment.newInstance(movie)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_activity_pager, detailsFragment)
            .commit()
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
}
