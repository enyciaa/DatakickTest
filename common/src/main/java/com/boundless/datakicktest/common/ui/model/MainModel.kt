package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.ui.states.ProductViewState
import com.boundless.datakicktest.common.usecases.filterByBooks
import com.boundless.datakicktest.common.usecases.mapToProductViewStates
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

class MainModel(
    private val coreroutineContextProvider: CoreroutineContextProvider,
    private val productsRepository: ProductsRepository
) {

  fun fetchProducts(): Deferred<List<ProductViewState>> =
      async(coreroutineContextProvider.commonPool) {
        productsRepository.fetchProducts()
            .mapToProductViewStates()
      }

  fun fetchBooks(): Deferred<List<ProductViewState>> =
      async(coreroutineContextProvider.commonPool) {
        productsRepository.fetchProducts()
            .filterByBooks()
            .mapToProductViewStates()
      }

  fun fetchFood(): Deferred<List<ProductViewState>> =
      async(coreroutineContextProvider.commonPool) {
        productsRepository.fetchProducts()
            .filterByBooks()
            .mapToProductViewStates()
      }
}
