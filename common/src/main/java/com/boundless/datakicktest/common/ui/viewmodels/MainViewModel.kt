package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.CoreroutineContextProvider
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.usecases.ProductFetcher

class MainViewModel(
        coreRoutineContextProvider: CoreroutineContextProvider,
        private val productFetcher: ProductFetcher
) : MotherViewModel<MainViewState>(coreRoutineContextProvider) {

    override var lastViewState: MainViewState = MainViewState()

    override fun onAttach() {
        super.onAttach()
        emitViewState(lastViewState)
        showAllProducts()
    }

    fun filterByBooks() {
        launchDefaultCoreRoutine {
            val books = productFetcher.books()
            emitViewState(lastViewState.copy(products = books))
        }
    }

    fun filterByFood() {
        launchDefaultCoreRoutine {
            val food = productFetcher.food()
            emitViewState(lastViewState.copy(products = food))
        }
    }

    fun showAllProducts() {
        launchDefaultCoreRoutine {
            val allProducts = productFetcher.allProducts()
            emitViewState(lastViewState.copy(products = allProducts))
        }
    }
}
