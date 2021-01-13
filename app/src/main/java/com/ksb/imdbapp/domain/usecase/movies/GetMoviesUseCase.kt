package com.ksb.imdbapp.domain.usecase.movies

import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.domain.repository.MoviesRepository

class GetMoviesUseCase(private val movieRepository: MoviesRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}