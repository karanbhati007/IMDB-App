package com.ksb.imdbapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ksb.imdbapp.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artist: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteArtists()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtists(): List<Artist>

}