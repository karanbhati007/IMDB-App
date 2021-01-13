package com.ksb.imdbapp.data.repository.tvshow.dataSourceImpl

import com.ksb.imdbapp.data.db.dao.MovieDao
import com.ksb.imdbapp.data.db.dao.TvShowsDao
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.model.tvshow.TvShow
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowsDao) : TvShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TvShow> = tvShowDao.getTvShows() //  This will run automatically on Background Thread by RoomDB

    override suspend fun saveTvShowToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShow)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteTvShows()
        }
    }
}