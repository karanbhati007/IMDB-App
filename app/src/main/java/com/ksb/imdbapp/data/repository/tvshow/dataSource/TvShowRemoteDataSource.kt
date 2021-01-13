package com.ksb.imdbapp.data.repository.tvshow.dataSource

import com.ksb.imdbapp.data.model.movies.MovieList
import com.ksb.imdbapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>
}