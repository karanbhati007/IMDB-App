package com.ksb.imdbapp.data.repository.artist.dataSource

import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.data.model.movies.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}