package com.example.myapplication

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.Coin
import com.example.myapplication.domain.usecase.GetCoinsRetrofitUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinsRetrofitUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: CoinRepository

    lateinit var getCoinsRetrofitUseCase: GetCoinsRetrofitUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getCoinsRetrofitUseCase = GetCoinsRetrofitUseCase(repository)
    }

    @Test
    fun `when The Api Doesnt Return Anything Then Get Values From DataBase`() = runBlocking {
        //Given
        coEvery { repository.getAllCoinsFromApi() } returns emptyList()
        //When
        getCoinsRetrofitUseCase()
        //Then
        coVerify(exactly = 1) { repository.getAllCoinsFromDatabase() }
    }

    @Test
    suspend fun `when the api return something then get values from api`() {
        //Given
        val myList = listOf(
            Coin(
                "btc_mxn",
                ".003",
                "1000.0",
                "100.0",
                "1000000.00",
                "25.0",
                "1000000.0"
            )
        )
        coEvery { repository.getAllCoinsFromApi() } returns myList
        //When
        val response = getCoinsRetrofitUseCase()

        //Then
        coVerify(exactly = 1) { repository.clearCoin() }
        coVerify(exactly = 1) { repository.insertCoins(any()) }
        coVerify(exactly = 0) { repository.getAllCoinsFromDatabase() }
        assert(myList == response)
    }
}