package com.ksb.imdbapp.data.api

import com.ksb.imdbapp.data.model.artist.ArtistList
import com.ksb.imdbapp.data.model.movies.MovieList
import com.ksb.imdbapp.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

/*    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }*/

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularArtist(@Query("api_key") api: String): Response<ArtistList>

    @GET("person/popular")
    suspend fun getPopularTvShows(@Query("api_key") api: String): Response<TvShowList>
}