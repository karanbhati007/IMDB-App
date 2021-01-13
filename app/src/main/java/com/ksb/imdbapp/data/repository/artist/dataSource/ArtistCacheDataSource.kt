package com.ksb.imdbapp.data.repository.artist.dataSource

import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.data.model.movies.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}