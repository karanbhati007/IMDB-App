package com.ksb.imdbapp.presentation.di.core

import com.ksb.imdbapp.data.repository.artist.ArtistRepositoryImpl
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistCacheDataSource
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistLocalDataSource
import com.ksb.imdbapp.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.ksb.imdbapp.data.repository.movie.MovieRepositoryImpl
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieCacheDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieLocalDataSource
import com.ksb.imdbapp.data.repository.movie.dataSource.MovieRemoteDataSource
import com.ksb.imdbapp.data.repository.tvshow.TvShowRepositoryImpl
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowCacheDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowLocalDataSource
import com.ksb.imdbapp.data.repository.tvshow.dataSource.TvShowRemoteDataSource
import com.ksb.imdbapp.domain.repository.ArtistsRepository
import com.ksb.imdbapp.domain.repository.MoviesRepository
import com.ksb.imdbapp.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ):ArtistsRepository{
        return ArtistRepositoryImpl(artistCacheDataSource,artistLocalDataSource,artistRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
       movieCacheDataSource: MovieCacheDataSource,
       movieLocalDataSource: MovieLocalDataSource,
       movieRemoteDataSource: MovieRemoteDataSource
    ):MoviesRepository{
        return MovieRepositoryImpl(movieCacheDataSource,movieLocalDataSource,movieRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ):TvShowsRepository{
        return TvShowRepositoryImpl(tvShowCacheDataSource, tvShowLocalDataSource, tvShowRemoteDataSource)
    }
}