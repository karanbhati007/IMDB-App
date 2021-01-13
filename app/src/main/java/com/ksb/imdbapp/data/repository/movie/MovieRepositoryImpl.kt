package com.ksb.imdbapp.data.repository.movie

import android.util.Log
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.ksb.imdbapp.domain.repository.MoviesRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
): MoviesRepository {

    private val TAG = "MovieRepositoryImpl"

    override suspend fun getMovies(): List<Movie>? {
       return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi():List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            val response =  movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>

        try{
           movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }
        return if(movieList.isNotEmpty())
            movieList
        else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
            movieList
        }
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>

        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }
        return if(movieList.isNotEmpty())
            movieList
        else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
            movieList
        }
    }
}