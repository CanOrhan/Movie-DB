package uk.co.kiwisoft.moviedb.domain.movies

import io.reactivex.rxjava3.core.Single
import uk.co.kiwisoft.moviedb.data.tmdb_api.MovieDbHttpService
import uk.co.kiwisoft.moviedb.data.tmdb_api.MoviesDbApi

//Dagger?
class MoviesInteractor(val api: MoviesDbApi = MovieDbHttpService.api) : MoviesUseCase {
    override fun getMovies(): Single<List<Movie>> = api.x().map {
        it.results
    }
}