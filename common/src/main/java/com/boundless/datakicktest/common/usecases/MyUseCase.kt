package com.boundless.datakicktest.common.usecases

import com.boundless.datakicktest.common.entities.AndroidStarter

fun AndroidStarter.doSomething(): AndroidStarter {
  return AndroidStarter("use cased hello")
}
