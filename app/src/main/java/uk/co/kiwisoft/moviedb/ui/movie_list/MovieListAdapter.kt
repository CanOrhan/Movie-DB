package uk.co.kiwisoft.moviedb.ui.movie_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import uk.co.kiwisoft.moviedb.R
import uk.co.kiwisoft.moviedb.databinding.MovieItemBinding
import uk.co.kiwisoft.moviedb.domain.movies.Movie


class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val _movies: MutableList<Movie> = mutableListOf()

    fun setMovies(value: List<Movie>) {
        _movies.clear()
        _movies.addAll(value)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val movieItemBinding = DataBindingUtil.inflate<MovieItemBinding>(
            layoutInflater,
            R.layout.movie_item,
            parent,
            false
        )

        return MovieViewHolder(movieItemBinding)
    }

    override fun getItemCount(): Int = _movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.movie = _movies[position]
    }

}

class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)