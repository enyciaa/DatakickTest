package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.ui.states.ProductViewState
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class MainModel(
    private val coreroutineContextProvider: CoreroutineContextProvider,
    private val productsRepository: ProductsRepository
) {

  fun fetchProducts(): Deferred<List<ProductViewState>> =
      fetchAllProducts()
          .map { it.mapToProductViewStates() }

  fun fetchBooks(): Deferred<List<ProductViewState>> =
      fetchAllProducts()
          .map { it.filterByBooks() }
          .map { it.mapToProductViewStates() }

  fun fetchFood(): Deferred<List<ProductViewState>> =
      fetchAllProducts()
          .map { it.filterByFood() }
          .map { it.mapToProductViewStates() }

  private fun fetchAllProducts(): Deferred<List<Product>> =
      async(coreroutineContextProvider.commonPool) {
        productsRepository.fetchProducts()
      }
}
