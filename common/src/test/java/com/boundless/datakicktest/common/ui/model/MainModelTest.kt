package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.testinfastructure.TestThreadProvider
import com.boundless.datakicktest.testinfastructure.aFoodItemBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class MainModelTest {

  private val threadProvider = TestThreadProvider()
  private val productsRepository: ProductsRepository = mockk()
  private val model = MainModel(
      threadProvider,
      productsRepository
  )

  @Test
  fun givenProducts_whenFetchProducts_fetchProductsFromRepository() {
    val products = listOf<Product>(aFoodItemBuilder().build())
    every { productsRepository.fetchProducts() } returns Single.just(products)

    model.fetchProducts()

    verify { productsRepository.fetchProducts() }
  }
}
