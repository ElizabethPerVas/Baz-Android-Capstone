package com.example.myapplication

import com.example.myapplication.data.CoinRepository
import com.example.myapplication.data.model.request.OrderRequest
import com.example.myapplication.domain.usecasedetailcoin.GetDetailCoinsRetrofitUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDetailCoinsRetrofitUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: CoinRepository

    lateinit var getDetailCoinsRetrofitUseCase: GetDetailCoinsRetrofitUseCase
    val request: OrderRequest = OrderRequest(true, "btc_mxn")

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getDetailCoinsRetrofitUseCase = GetDetailCoinsRetrofitUseCase(repository)
    }

    @Test
    fun `when The Api Doesnt Return Anything Then Get Values From DataBase`() = runBlocking {
        //Given
        coEvery { repository.getDetailCoinsFromApi(request) }
        //When
        getDetailCoinsRetrofitUseCase(request)
        //Then
        coVerify(exactly = 1) { repository.getDetailCoinsFromDatabase(request) }
    }
}