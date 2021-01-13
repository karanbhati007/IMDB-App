package com.ksb.imdbapp.data.repository.tvshow.dataSource

import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}