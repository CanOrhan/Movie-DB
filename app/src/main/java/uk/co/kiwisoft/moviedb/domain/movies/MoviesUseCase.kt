package uk.co.kiwisoft.moviedb.domain.movies

import io.reactivex.rxjava3.core.Single
import uk.co.kiwisoft.moviedb.data.Movie

interface MoviesUseCase {
    fun getMovies(): Single<List<Movie>>
}