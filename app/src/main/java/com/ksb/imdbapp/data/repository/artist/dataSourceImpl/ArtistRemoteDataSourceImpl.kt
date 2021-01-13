package com.ksb.imdbapp.data.repository.artist.dataSourceImpl

import com.ksb.imdbapp.data.api.TMDBService
import com.ksb.imdbapp.data.model.artist.ArtistList
import com.ksb.imdbapp.data.model.movies.MovieList
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmbdService: TMDBService,
    private val api_key: String
    ): ArtistRemoteDataSource {

    override suspend fun getArtist(): Response<ArtistList> = tmbdService.getPopularArtist(api_key)
}