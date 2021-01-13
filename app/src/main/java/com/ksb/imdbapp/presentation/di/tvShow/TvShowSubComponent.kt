package com.ksb.imdbapp.presentation.di.tvShow

import com.ksb.imdbapp.presentation.artist.ArtistActivity
import com.ksb.imdbapp.presentation.tvShow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}