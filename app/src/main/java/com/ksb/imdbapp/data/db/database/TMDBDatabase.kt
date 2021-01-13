package com.ksb.imdbapp.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.data.model.movies.Movie
import com.ksb.imdbapp.data.model.tvshow.TvShow
import com.ksb.imdbapp.data.db.dao.ArtistDao
import com.ksb.imdbapp.data.db.dao.MovieDao
import com.ksb.imdbapp.data.db.dao.TvShowsDao

@Database(entities = [Movie::class,TvShow::class,Artist::class],version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowsDao
    abstract fun artistDao(): ArtistDao
}