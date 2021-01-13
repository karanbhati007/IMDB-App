package com.ksb.imdbapp.data.repository.artist.dataSourceImpl

import com.ksb.imdbapp.data.db.dao.ArtistDao
import com.ksb.imdbapp.data.db.dao.MovieDao
import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {

    override suspend fun getArtistFromDB(): List<Artist> = artistDao.getArtists() //  This will run automatically on Background Thread by RoomDB

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtists()
        }
    }
}