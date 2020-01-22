package uk.co.kiwisoft.moviedb.data.tmdb_api

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * ToDo: Dagger?
 */
object MovieDbHttpService {

    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .build()


    val api = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(MoviesDbApi::class.java)
}