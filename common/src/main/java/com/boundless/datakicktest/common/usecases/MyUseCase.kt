package com.boundless.datakicktest.common.usecases

import com.boundless.datakicktest.common.entities.Book
import com.boundless.datakicktest.common.entities.Product

fun List<Product>.doSomething(): Book {
  return Book("use cased hello", "", "")
}
