package com.boundless.datakicktest.common.ui.model

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.repositories.MyRepository
import com.boundless.datakicktest.common.usecases.doSomething
import com.boundless.elephant.threading.ThreadProvider
import io.reactivex.Single

class MainModel(
    private val threadProvider: ThreadProvider,
    private val myRepository: MyRepository
) {

  fun fetchValue(): Single<Book> =
      Single.fromCallable { myRepository.fetchValue() }
          .subscribeOn(threadProvider.io)
          .map { it.doSomething() }
          .observeOn(threadProvider.main)

  fun saveValue(value: Book) =
      Single.fromCallable { myRepository.saveValue(value) }
          .subscribeOn(threadProvider.io)
          .observeOn(threadProvider.main)
}
