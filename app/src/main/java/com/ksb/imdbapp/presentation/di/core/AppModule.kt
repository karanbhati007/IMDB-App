package com.ksb.imdbapp.presentation.di.core

import android.content.Context
import com.ksb.imdbapp.presentation.di.artist.ArtistSubComponent
import com.ksb.imdbapp.presentation.di.movie.MovieSubComponent
import com.ksb.imdbapp.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSubComponent::class,TvShowSubComponent::class])
class AppModule(private val context:Context) { // It provides Application Context Dependency

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }

}