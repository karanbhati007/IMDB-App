package com.ksb.imdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ksb.imdbapp.data.model.tvshow.TvShow

@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getTvShows(): List<TvShow>
}