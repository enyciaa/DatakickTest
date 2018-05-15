package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.ui.states.ProductViewState
import com.boundless.elephant.threading.ThreadProvider
import io.reactivex.Single

class MainModel(
    private val threadProvider: ThreadProvider,
    private val productsRepository: ProductsRepository
) {

  fun fetchProducts(): Single<List<ProductViewState>> =
      productsRepository.fetchProducts()
          .subscribeOn(threadProvider.io)
          .map { it.mapToProductViewStates() }
          .observeOn(threadProvider.main)
}
