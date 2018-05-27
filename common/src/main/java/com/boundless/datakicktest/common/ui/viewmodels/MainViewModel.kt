package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.model.MainModel
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import kotlinx.coroutines.experimental.launch

class MainViewModel(
    private val mainModel: MainModel,
    private val coreroutineContextProvider: CoreroutineContextProvider
) : MotherViewModel() {

  private var lastViewState: MainViewState = MainViewState()
  private val viewState: BehaviorRelay<MainViewState> = BehaviorRelay.createDefault(lastViewState)

  fun getViewState(): Observable<MainViewState> = viewState

  override fun onAttach() {
    super.onAttach()
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

  private fun emitViewState(newViewState: MainViewState) {
    lastViewState = newViewState
    viewState.accept(newViewState)
  }
}
