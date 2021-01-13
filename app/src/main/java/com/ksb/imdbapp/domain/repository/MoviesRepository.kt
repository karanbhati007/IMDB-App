package com.ksb.imdbapp.domain.repository

import com.ksb.imdbapp.data.model.movies.Movie

interface MoviesRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}