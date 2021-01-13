package com.ksb.imdbapp.presentation

import android.app.Application
import com.ksb.imdbapp.BuildConfig
import com.ksb.imdbapp.presentation.di.Injector
import com.ksb.imdbapp.presentation.di.artist.ArtistSubComponent
import com.ksb.imdbapp.presentation.di.core.*
import com.ksb.imdbapp.presentation.di.movie.MovieSubComponent
import com.ksb.imdbapp.presentation.di.tvShow.TvShowSubComponent

class App: Application(),Injector {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
    return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
    return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
    return appComponent.artistSubComponent().create()
    }
}