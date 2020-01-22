package uk.co.kiwisoft.moviedb.data.tmdb_api

import okhttp3.Interceptor
import okhttp3.Response
import uk.co.kiwisoft.moviedb.BuildConfig

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TmdbApiKey)
            .build()

        val request = chain
            .request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}