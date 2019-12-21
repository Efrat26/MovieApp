package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Movie_Adapter(context: Context,
                    private val movieClickListener: OnMovieClickListener) : RecyclerView.Adapter<ViewHolder>() {

    private val movies = mutableListOf<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater
            .inflate(R.layout.activity_movies, parent, false)
        return ViewHolder(view, movieClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])

    }

    fun setData(newItems: List<MovieModel>){
        movies.clear()
        movies.addAll(newItems)
        notifyDataSetChanged()
    }



    private val layoutInflater: LayoutInflater = context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount(): Int = movies.size



}

