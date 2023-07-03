package com.example.marvelapp.framework

import androidx.paging.PagingSource
import com.example.marvelapp.data.repository.CharactersRemoteDatasource
import com.example.marvelapp.data.repository.CharactersRepository
import com.example.marvelapp.domain.model.Character
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.paging.CharactersPagingSource
import javax.inject.Inject

/**
 * Depende de uma abstração e não de uma implementação
 */
class CharactersRepositoryImpl @Inject constructor(
    private val remoteDatasource: CharactersRemoteDatasource<DataWrapperResponse>
) : CharactersRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDatasource, query)
    }
}