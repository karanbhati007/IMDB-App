package com.ksb.imdbapp.presentation.di.artist

import com.ksb.imdbapp.domain.usecase.artists.GetArtistsUseCase
import com.ksb.imdbapp.domain.usecase.artists.UpdateArtistsUseCase
import com.ksb.imdbapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModel(getArtistsUseCase: GetArtistsUseCase,
                               updateArtistsUseCase: UpdateArtistsUseCase):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase,updateArtistsUseCase)
    }
}