package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.Coin
import com.example.myapplication.domain.usecase.GetCoinsRetrofitUseCase
import com.example.myapplication.ui.viewmodel.CoinViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalStdlibApi
class CoinViewModelTest {

    @RelaxedMockK
    private lateinit var getCoinsRetrofitUseCase: GetCoinsRetrofitUseCase

    @RelaxedMockK
    private lateinit var coinViewModel: CoinViewModel

    @RelaxedMockK
    private lateinit var repository: CoinRepository

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getCoinsRetrofitUseCase = GetCoinsRetrofitUseCase(repository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first time get all coins and set the value`() = runTest {
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
            ),
            Coin(
                "eth_mxn",
                ".003",
                "1000.0",
                "100.0",
                "1000000.00",
                "25.0",
                "1000000.0"
            ),
        )
        coEvery { getCoinsRetrofitUseCase() } returns myList

        //When
        coinViewModel.getCoin()
        //Then
        assert(coinViewModel.coinsLiveData.value == myList)

    }
}