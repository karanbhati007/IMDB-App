package com.ksb.imdbapp.presentation.di.core

import com.ksb.imdbapp.data.db.dao.ArtistDao
import com.ksb.imdbapp.data.db.dao.MovieDao
import com.ksb.imdbapp.data.db.dao.TvShowsDao
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.ksb.imdbapp.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.ksb.imdbapp.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowsDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}