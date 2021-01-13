package com.ksb.imdbapp.presentation.di.movie

import com.ksb.imdbapp.presentation.artist.ArtistActivity
import com.ksb.imdbapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}