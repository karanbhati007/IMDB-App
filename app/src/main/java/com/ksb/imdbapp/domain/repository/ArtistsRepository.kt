package com.ksb.imdbapp.domain.repository

import com.ksb.imdbapp.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}