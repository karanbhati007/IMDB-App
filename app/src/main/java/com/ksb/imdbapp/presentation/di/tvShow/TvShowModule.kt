package com.ksb.imdbapp.presentation.di.tvShow

import com.ksb.imdbapp.domain.usecase.artists.GetArtistsUseCase
import com.ksb.imdbapp.domain.usecase.artists.UpdateArtistsUseCase
import com.ksb.imdbapp.domain.usecase.tvShows.GetTvShowsUseCase
import com.ksb.imdbapp.domain.usecase.tvShows.UpdateTvShowUseCase
import com.ksb.imdbapp.presentation.artist.ArtistViewModelFactory
import com.ksb.imdbapp.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideArtistViewModel(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowUseCase)
    }
}