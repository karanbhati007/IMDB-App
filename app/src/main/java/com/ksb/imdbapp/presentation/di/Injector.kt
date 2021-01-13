package com.ksb.imdbapp.presentation.di

import com.ksb.imdbapp.presentation.di.artist.ArtistSubComponent
import com.ksb.imdbapp.presentation.di.movie.MovieSubComponent
import com.ksb.imdbapp.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}