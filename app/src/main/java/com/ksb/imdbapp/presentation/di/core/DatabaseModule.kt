package com.ksb.imdbapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.ksb.imdbapp.data.db.dao.ArtistDao
import com.ksb.imdbapp.data.db.dao.MovieDao
import com.ksb.imdbapp.data.db.dao.TvShowsDao
import com.ksb.imdbapp.data.db.database.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule{

    @Singleton
    @Provides
    fun provideMovieDatabase(context:Context): TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbClient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providesArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun providesTvShowDao(tmdbDatabase: TMDBDatabase): TvShowsDao{
        return tmdbDatabase.tvShowDao()
    }

}