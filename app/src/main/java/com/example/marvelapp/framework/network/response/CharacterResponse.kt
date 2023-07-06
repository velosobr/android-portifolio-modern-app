package com.example.marvelapp.framework.network.response

import com.example.marvelapp.domain.model.Character

data class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnailResponse: ThumbnailResponse
)

fun CharacterResponse.toCharacterModel(): Character {
    return Character(
        name = this.name,
        imageUrl = "${this.thumbnailResponse.path}.${this.thumbnailResponse.extension}".replace(
            "http", "https"
        )
    )
}
