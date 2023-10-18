package com.example.marvelapp.presentation.characters

import androidx.paging.PagingData
import androidx.paging.map
import com.example.marvelapp.domain.model.Character
import com.example.marvelapp.usecase.GetCharactersUseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    @ExperimentalCoroutinesApi
    val testDispatcher: TestDispatcher = StandardTestDispatcher()

    private lateinit var charactersViewModel: CharactersViewModel

    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private val pagingDataCharacters = PagingData.from(
        listOf(
            Character(
                name = "3-D Man",
                imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
            ),
            Character(
                name = "A-Bomb (HAS)",
                imageUrl = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg"
            )
        )
    )

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        charactersViewModel = CharactersViewModel(getCharactersUseCase)

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should validade the paging data object values when calling charactersPagingData`() =
        runBlockingTest {

            whenever(
                getCharactersUseCase.invoke(any())
            ).thenReturn(
                flowOf(
                    pagingDataCharacters
                )
            )

            val result = charactersViewModel.charactersPagingData("")


            assertEquals(1, result.count())
        }

}