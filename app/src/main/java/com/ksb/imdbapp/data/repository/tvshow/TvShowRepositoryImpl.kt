package com.ksb.imdbapp.data.repository.tvshow

import android.util.Log
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.model.tvshow.TvShow
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import com.ksb.imdbapp.domain.repository.TvShowsRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
): TvShowsRepository {

    private val TAG = "TvShowRepositoryImpl"

    override suspend fun getTvShows(): List<TvShow>? {
       return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowFromApi():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try{
            val response =  tvShowRemoteDataSource.getTvShow()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }

        return  tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try{
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }
        return if(tvShowList.isNotEmpty())
            tvShowList
        else{
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
            tvShowList
        }
    }

    suspend fun getTvShowFromCache():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try{
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }
        return if(tvShowList.isNotEmpty())
            tvShowList
        else{
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
            tvShowList
        }
    }
}