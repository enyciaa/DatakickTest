package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.usecases.ProductFetcher
import kotlinx.coroutines.experimental.launch

class MainViewModel(
        private val coreroutineContextProvider: CoreroutineContextProvider,
        private val productFetcher: ProductFetcher
) : MotherViewModel<MainViewState>() {

    override var lastViewState: MainViewState = MainViewState()

    override fun onAttach() {
        super.onAttach()
        emitViewState(lastViewState)
        showAllProducts()
    }

    fun filterByBooks() {
        launch(coreroutineContextProvider.commonPool, parent = coreroutineManager) {
            val books = productFetcher.books()
            emitViewState(lastViewState.copy(products = books))
        }
    }

    fun filterByFood() {
        launch(coreroutineContextProvider.commonPool, parent = coreroutineManager) {
            val food = productFetcher.food()
            emitViewState(lastViewState.copy(products = food))
        }
    }

    fun showAllProducts() {
        launch(coreroutineContextProvider.commonPool, parent = coreroutineManager) {
            val allProducts = productFetcher.allProducts()
            emitViewState(lastViewState.copy(products = allProducts))
        }
    }
}
