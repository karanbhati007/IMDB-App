package com.ksb.imdbapp.data.repository.tvshow.dataSourceImpl

import com.ksb.imdbapp.data.api.TMDBService
import com.ksb.imdbapp.data.model.movies.MovieList
import com.ksb.imdbapp.data.model.tvshow.TvShowList
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmbdService: TMDBService,
    private val api_key: String
    ): TvShowRemoteDataSource {

    override suspend fun getTvShow(): Response<TvShowList> = tmbdService.getPopularTvShows(api_key)
}