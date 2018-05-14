package com.boundless.datakicktest.common.repositories

import com.boundless.datakicktest.common.entities.AndroidStarter

class MyRepository {

  private var cachedValue: AndroidStarter? = null

  fun fetchValue(): AndroidStarter {
    return cachedValue ?: AndroidStarter("hello")
  }

  fun saveValue(value: AndroidStarter) {
    cachedValue = value
  }
}
