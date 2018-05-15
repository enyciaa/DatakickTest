package com.boundless.datakicktest.testinfastructure

import com.boundless.datakicktest.common.ui.states.BookItemViewState

class BookItemViewStateBuilder {

  fun build() = BookItemViewState(
      ""
  )
}

fun aBookItemViewState() = BookItemViewStateBuilder()
