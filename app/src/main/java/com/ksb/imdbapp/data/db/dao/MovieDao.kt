package com.ksb.imdbapp.data.db.dao

import androidx.room.*
import com.ksb.imdbapp.data.model.movies.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movie")
    suspend fun deleteMovies()

    @Query("SELECT * FROM popular_movie")
    suspend fun getMovies(): List<Movie>

}