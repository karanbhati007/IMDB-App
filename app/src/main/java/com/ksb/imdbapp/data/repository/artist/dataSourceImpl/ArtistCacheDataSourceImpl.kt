package com.ksb.imdbapp.data.repository.artist.dataSourceImpl

import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}