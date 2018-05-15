package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.repositories.ProductsRepository
import com.boundless.datakicktest.common.usecases.doSomething
import com.boundless.elephant.threading.ThreadProvider
import io.reactivex.Single

class MainModel(
    private val threadProvider: ThreadProvider,
    private val productsRepository: ProductsRepository
) {

  fun fetchValue(): Single<Book> =
      productsRepository.fetchProducts()
          .subscribeOn(threadProvider.io)
          .map { it.doSomething() }
          .observeOn(threadProvider.main)
}
