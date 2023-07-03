package com.example.marvelapp.data.repository

import androidx.paging.PagingSource
import com.example.marvelapp.domain.model.Character

interface CharactersRepository {
    fun getCharacters(query: String): PagingSource<Int, Character>
}