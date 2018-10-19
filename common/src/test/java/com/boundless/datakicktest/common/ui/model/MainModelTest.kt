package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.usecases.ProductFetcher
import com.boundless.datakicktest.testinfastructure.TestCoroutineCtxProvider
import com.boundless.datakicktest.testinfastructure.aFoodItemBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class MainModelTest {

  private val coreroutineContextProvider = TestCoroutineCtxProvider()
  private val productsRepository: ProductsRepository = mockk()
  private val model = ProductFetcher(
          coreroutineContextProvider,
          productsRepository
  )

  @Test
  fun givenProducts_whenFetchProducts_fetchProductsFromRepository() {
    val products = listOf<Product>(aFoodItemBuilder().build())
    every { productsRepository.fetchProducts() } returns Single.just(products)

    model.allProducts()

    verify { productsRepository.fetchProducts() }
  }
}
