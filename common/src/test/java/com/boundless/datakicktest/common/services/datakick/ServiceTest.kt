package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.aFoodItemBuilder
import com.boundless.datakicktest.aRawDataKickResponseBuilder
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.entities.RawDataKickResponse
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.amshove.kluent.shouldEqual
import org.junit.Test

class ServiceTest {

  private val dataKickApi: DataKickApi = mockk()
  private val service = DataKickService(dataKickApi)

  @Test
  fun givenApiResult_whenFetched_returnProducts() {
    val brandName = "kellogs"
    val foodItemResponse = aRawDataKickResponseBuilder().withBrandName(brandName).build()
    val apiResults: List<RawDataKickResponse> = listOf(foodItemResponse)
    every { dataKickApi.fetchItems() } returns Single.just(apiResults)
    val expectedResult: List<Product> = listOf(aFoodItemBuilder().withBrandName(brandName).build())

    val result = service.fetchItems().blockingGet()

    result shouldEqual expectedResult
  }
}