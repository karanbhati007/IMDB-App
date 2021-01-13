package com.ksb.imdbapp.data.repository.artist.dataSource

import com.ksb.imdbapp.data.model.artist.ArtistList
import com.ksb.imdbapp.data.model.movies.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}