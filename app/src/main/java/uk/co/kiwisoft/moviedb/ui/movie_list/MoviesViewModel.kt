package uk.co.kiwisoft.moviedb.ui.movie_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import uk.co.kiwisoft.moviedb.domain.movies.Movie
import uk.co.kiwisoft.moviedb.domain.movies.MoviesInteractor
import uk.co.kiwisoft.moviedb.domain.movies.MoviesUseCase

class MoviesViewModel(moviesUseCase: MoviesUseCase) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    private val compositeDisposable = CompositeDisposable()

    val movies: LiveData<List<Movie>> = _movies

    init {
        val getMoviesDisposable = moviesUseCase
            .getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { movieList ->
                _movies.value = movieList
            }

        compositeDisposable.add(getMoviesDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

class MoviesViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(MoviesUseCase::class.java)
            .newInstance(MoviesInteractor()) //Inject.
    }
}