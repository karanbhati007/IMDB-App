package com.ksb.imdbapp.data.repository.tvshow.dataSourceImpl

import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.model.tvshow.TvShow
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvShow = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShow
    }

    override suspend fun saveTvShowToCache(movies: List<TvShow>) {
        tvShow.clear()
        tvShow = ArrayList(movies)
    }
}