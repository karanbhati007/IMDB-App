package com.ksb.imdbapp.data.repository.movie.dataSourceImpl

import com.ksb.imdbapp.data.db.dao.MovieDao
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies() //  This will run automatically on Background Thread by RoomDB

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteMovies()
        }
    }
}