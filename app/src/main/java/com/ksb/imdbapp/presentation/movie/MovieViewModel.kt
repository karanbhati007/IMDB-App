package com.ksb.imdbapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ksb.imdbapp.domain.usecase.movies.GetMoviesUseCase
import com.ksb.imdbapp.domain.usecase.movies.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovieList() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}