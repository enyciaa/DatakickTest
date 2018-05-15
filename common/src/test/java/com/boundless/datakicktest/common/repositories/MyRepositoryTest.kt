package com.boundless.datakicktest.common.repositories

import com.boundless.datakicktest.aFoodItemBuilder
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.services.datakick.DataKickService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class MyRepositoryTest {

  private val dataKickService: DataKickService = mockk()
  private val repository = ProductsRepository(
      dataKickService
  )

  @Test
  fun givenNoCachedValue_whenFetchProducts_returnFromNetwork() {
    val products = listOf<Product>(aFoodItemBuilder().build())
    every { dataKickService.fetchProducts() } returns Single.just(products)

    repository.fetchProducts()

    verify { dataKickService.fetchProducts() }
  }

  @Test
  fun givenCachedValue_whenFetchProducts_returnCachedProducts() {
    val products = listOf<Product>(aFoodItemBuilder().build())
    every { dataKickService.fetchProducts() } returns Single.just(products)
    repository.fetchProducts().blockingGet()

    repository.fetchProducts().blockingGet()

    verify(exactly = 1) { dataKickService.fetchProducts() }
  }
}