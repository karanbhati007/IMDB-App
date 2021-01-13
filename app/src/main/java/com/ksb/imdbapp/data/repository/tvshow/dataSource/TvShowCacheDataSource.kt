package com.ksb.imdbapp.data.repository.tvshow.dataSource

import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(movies: List<TvShow>)
}