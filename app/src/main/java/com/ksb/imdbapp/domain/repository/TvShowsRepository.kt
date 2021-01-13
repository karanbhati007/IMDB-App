package com.ksb.imdbapp.domain.repository

import com.ksb.imdbapp.data.model.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}