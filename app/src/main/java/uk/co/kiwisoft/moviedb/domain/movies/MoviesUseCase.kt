package uk.co.kiwisoft.moviedb.domain.movies

import io.reactivex.rxjava3.core.Single

interface MoviesUseCase {
    fun getMovies(): Single<List<Movie>>
}