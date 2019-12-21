package com.example.movieapp;
import android.view.View
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movies.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivImage: ImageView = view.movie_photo
    private val tvTitle: TextView = view.movie_title
    private val tvOverview: TextView = view.movie_overview


    fun bind(movieModel : MovieModel){
        ivImage.setImageResource(movieModel.imageRes)
        tvTitle.text = movieModel.name
        tvOverview.text = movieModel.overview


    }
}


