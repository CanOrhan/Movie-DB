package uk.co.kiwisoft.moviedb.data.tmdb_api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import uk.co.kiwisoft.moviedb.data.Movie
import uk.co.kiwisoft.moviedb.data.Result


interface MoviesDbApi {
    @GET("movie/now_playing?language=en-US&page=1")
    fun x(): Single<Result<List<Movie>>>
}