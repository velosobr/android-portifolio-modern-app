package com.example.marvelapp.data.repository

interface CharactersRemoteDatasource<T> {
    suspend fun fetchCharacters(queries: Map<String, String>): T
}