package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoroutineCtxProvider
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.usecases.ProductFetcher
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class MainViewModel(
        private val coroutineCtxProvider: CoroutineCtxProvider,
        private val productFetcher: ProductFetcher
) : MotherViewModel<MainViewState>() {

    override var lastViewState: MainViewState = MainViewState()

    override fun onAttach() {
        super.onAttach()
        emitViewState(lastViewState)
        showAllProducts()
    }

    fun showAllProducts() {
        launch(coroutineCtxProvider.UI, parent = coreroutineManager) {
            try {
                val allProducts = withContext(coroutineCtxProvider.commonPool) { productFetcher.allProducts() }
                emitViewState(lastViewState.withProducts(allProducts))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByBooks() {
        launch(coroutineCtxProvider.commonPool, parent = coreroutineManager) {
            try {
                val books = withContext(coroutineCtxProvider.commonPool) { productFetcher.books() }
                emitViewState(lastViewState.withProducts(books))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }

    fun filterByFood() {
        launch(coroutineCtxProvider.commonPool, parent = coreroutineManager) {
            try {
                val food = withContext(coroutineCtxProvider.commonPool) { productFetcher.food() }
                emitViewState(lastViewState.withProducts(food))
            } catch (exception: Exception) {
                // Handle custom errors here
                emitViewState(lastViewState.copy(errorState = true))
            }
        }
    }
}
