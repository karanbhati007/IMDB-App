package com.ksb.imdbapp.domain.usecase.tvShows

import com.ksb.imdbapp.data.model.tvshow.TvShow
import com.ksb.imdbapp.domain.repository.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute():List<TvShow>? = tvShowsRepository.getTvShows()
}