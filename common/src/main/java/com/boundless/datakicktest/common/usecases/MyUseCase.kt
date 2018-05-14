package com.boundless.datakicktest.common.usecases

import com.boundless.datakicktest.common.entities.Book

fun Book.doSomething(): Book {
  return Book("use cased hello", "", "")
}
