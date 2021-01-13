package com.ksb.imdbapp.data.repository.movie.dataSource

import com.ksb.imdbapp.data.model.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}