package com.ksb.imdbapp.domain.usecase.tvShows

import com.ksb.imdbapp.data.model.tvshow.TvShow
import com.ksb.imdbapp.domain.repository.TvShowsRepository

class UpdateTvShowUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.updateTvShows()
}