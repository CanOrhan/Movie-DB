package uk.co.kiwisoft.moviedb.ui.movie_list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import uk.co.kiwisoft.moviedb.R
import uk.co.kiwisoft.moviedb.databinding.MovieFragmentBinding

class MoviesFragment : Fragment() {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: MovieFragmentBinding
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        movieListAdapter = MovieListAdapter()
        binding = MovieFragmentBinding.inflate(inflater, container, false)
        with(binding.moviesList) {
            adapter = movieListAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Feel like this could be injected. Not thought about how, though.
        viewModel = ViewModelProviders
            .of(this, MoviesViewModelFactory())
            .get(MoviesViewModel::class.java)

        viewModel.movies.observe(this, Observer {
            movieListAdapter.setMovies(it)
        })
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}