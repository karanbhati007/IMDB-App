package com.ksb.imdbapp.domain.usecase.artists

import com.ksb.imdbapp.data.model.artist.Artist
import com.ksb.imdbapp.domain.repository.ArtistsRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistsRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}