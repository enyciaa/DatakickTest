package com.boundless.datakicktest.common.repositories

import com.boundless.datakicktest.common.entities.Book

class MyRepository {

  private var cachedValue: Book? = null

  fun fetchValue(): Book {
    return cachedValue ?: Book("hello", "", "")
  }

  fun saveValue(value: Book) {
    cachedValue = value
  }
}
