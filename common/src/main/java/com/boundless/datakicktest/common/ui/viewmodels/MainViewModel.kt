package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.model.MainModel
import com.boundless.datakicktest.common.ui.states.MainViewState
import kotlinx.coroutines.experimental.launch

class MainViewModel(
    private val mainModel: MainModel,
    private val coreroutineContextProvider: CoreroutineContextProvider
) : MotherViewModel<MainViewState>() {

  override var lastViewState: MainViewState = MainViewState()

  override fun onAttach() {
    super.onAttach()
    emitViewState(lastViewState)
    showAllProducts()
  }

  fun filterByBooks() {
    launch(coreroutineContextProvider.androidUi) {
      // Load here
      val books = mainModel.fetchBooks().await()
      emitViewState(lastViewState.copy(products = books))
      // error here
    }
  }

  fun filterByFood() {
    launch(coreroutineContextProvider.androidUi) {
      // Load here
      val food = mainModel.fetchFood().await()
      emitViewState(lastViewState.copy(products = food))
      // error here
    }
  }

  fun showAllProducts() {
    launch(coreroutineContextProvider.androidUi) {
      // Load here
      val allProducts = mainModel.fetchProducts().await()
      emitViewState(lastViewState.copy(products = allProducts))
      // error here
    }
  }
}
