package com.ksb.imdbapp.presentation.di.movie

import com.ksb.imdbapp.domain.usecase.artists.GetArtistsUseCase
import com.ksb.imdbapp.domain.usecase.artists.UpdateArtistsUseCase
import com.ksb.imdbapp.domain.usecase.movies.GetMoviesUseCase
import com.ksb.imdbapp.domain.usecase.movies.UpdateMoviesUseCase
import com.ksb.imdbapp.presentation.artist.ArtistViewModelFactory
import com.ksb.imdbapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideArtistViewModel(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}