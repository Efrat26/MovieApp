package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movies.view.*
import kotlinx.android.synthetic.main.movie_details.view.*


private class MoviesDiffUtilCallback : DiffUtil.ItemCallback<MovieModel>() {

    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.imageRes == newItem.imageRes
                && oldItem.name == newItem.name
                && oldItem.overview == newItem.overview
    }
}

class Movie_Adapter(context: Context,
                    private val movieClickListener: OnMovieClickListener) : RecyclerView.Adapter<Movie_Adapter.ViewHolder>() {


    private val layoutInflater: LayoutInflater = context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val asyncListDiffer = AsyncListDiffer<MovieModel>(this, MoviesDiffUtilCallback())


    override fun getItemCount() = asyncListDiffer.currentList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater
            .inflate(R.layout.activity_movies, parent, false)
        return ViewHolder(view, movieClickListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieModel = asyncListDiffer.currentList[position]
        holder.bind(movieModel)

    }

    fun setData(newItems: List<MovieModel>){
        asyncListDiffer.submitList(newItems)
    }




    inner class ViewHolder(view: View, movieClickListener: OnMovieClickListener) : RecyclerView.ViewHolder(view) {
        private val ivImage: ImageView = view.movie_photo
        private val tvTitle: TextView = view.movie_title
        private val tvOverview: TextView = view.movie_overview
       // private val releasedDate: TextView = view.released
      //  private val backgroundImage : ImageView = view.movie_details_poster


        private lateinit var movieModel: MovieModel
        init {
            view.setOnClickListener {
                movieClickListener.onMovieClicked(movieModel)
            }
        }

        fun bind(movieModel : MovieModel){
            ivImage.setImageResource(movieModel.imageRes)
            tvTitle.text = movieModel.name
            tvOverview.text = movieModel.overview
           // releasedDate.text = movieModel.releaseDate
           // backgroundImage.setImageResource(movieModel.backImageRes)
            //TODO add here movie details
            this.movieModel = movieModel
        }
    }

}




