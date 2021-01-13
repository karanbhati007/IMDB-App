package com.ksb.imdbapp.data.repository.artist

import android.util.Log
import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.ksb.imdbapp.domain.repository.ArtistsRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistCacheDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
): ArtistsRepository {

    private val TAG = "ArtistRepositoryImpl"

    override suspend fun getArtists(): List<Artist>? {
       return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistFromApi():List<Artist>{
        lateinit var artistList: List<Artist>

        try{
            val response =  artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }

        return artistList
    }

    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList: List<Artist>

        try{
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }
        return if(artistList.isNotEmpty())
            artistList
        else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
            artistList
        }
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList: List<Artist>

        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (e: Exception){
            Log.e(TAG, "Error :: ${e.message.toString()}")
        }
        return if(artistList.isNotEmpty())
            artistList
        else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
            artistList
        }
    }
}