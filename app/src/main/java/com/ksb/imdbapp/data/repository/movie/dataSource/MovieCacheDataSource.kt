package com.ksb.imdbapp.data.repository.movie.dataSource

import com.ksb.imdbapp.data.model.movies.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}