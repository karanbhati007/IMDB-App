package com.ksb.imdbapp.data.repository.movie.dataSource

import com.ksb.imdbapp.data.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}