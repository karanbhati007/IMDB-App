package com.ksb.imdbapp.data.repository.movie.dataSourceImpl

import com.ksb.imdbapp.data.api.TMDBService
import com.ksb.imdbapp.data.model.movies.MovieList
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmbdService: TMDBService,
    private val api_key: String
    ): MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmbdService.getPopularMovies(api_key)
}