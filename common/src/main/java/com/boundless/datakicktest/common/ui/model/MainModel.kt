package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.entities.Product
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.ui.states.ProductViewState
import com.boundless.datakicktest.common.usecases.filterByBooks
import com.boundless.datakicktest.common.usecases.filterByFood
import com.boundless.elephant.threading.ThreadProvider
import io.reactivex.Single

class MainModel(
    private val threadProvider: ThreadProvider,
    private val productsRepository: ProductsRepository
) {

  fun fetchProducts(): Single<List<ProductViewState>> =
      fetchAllProducts()
          .map { it.mapToProductViewStates() }

  fun fetchBooks(): Single<List<ProductViewState>> =
      fetchAllProducts()
          .map { it.filterByBooks() }
          .map { it.mapToProductViewStates() }

  fun fetchFood(): Single<List<ProductViewState>> =
      fetchAllProducts()
          .map { it.filterByFood() }
          .map { it.mapToProductViewStates() }

  private fun fetchAllProducts(): Single<List<Product>> =
      productsRepository.fetchProducts()
          .subscribeOn(threadProvider.io)
          .observeOn(threadProvider.main)
}
