package com.ksb.imdbapp.presentation.di.core

import com.ksb.imdbapp.domain.repository.ArtistsRepository
import com.ksb.imdbapp.domain.repository.MoviesRepository
import com.ksb.imdbapp.domain.repository.TvShowsRepository
import com.ksb.imdbapp.domain.usecase.artists.GetArtistsUseCase
import com.ksb.imdbapp.domain.usecase.artists.UpdateArtistsUseCase
import com.ksb.imdbapp.domain.usecase.movies.GetMoviesUseCase
import com.ksb.imdbapp.domain.usecase.movies.UpdateMoviesUseCase
import com.ksb.imdbapp.domain.usecase.tvShows.GetTvShowsUseCase
import com.ksb.imdbapp.domain.usecase.tvShows.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetArtistUseCase(artistsRepository: ArtistsRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistsRepository)
    }


    @Provides
    fun provideGetMovieUseCase(moviesRepository: MoviesRepository):GetMoviesUseCase{
        return GetMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(moviesRepository: MoviesRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(moviesRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository):UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowsRepository)
    }

}