package com.ksb.imdbapp.presentation.di.core

import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.ksb.imdbapp.data.repository.artist.dataSourceImpl.ArtistCacheDataSourceImpl
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.ksb.imdbapp.data.repository.movie.dataSourceImpl.MovieCacheDataSourceImpl
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}