package com.boundless.datakicktest.common.ui.viewmodels

import com.boundless.datakicktest.common.usecases.ProductFetcher
import com.boundless.datakicktest.common.ui.states.ProductViewState
import com.boundless.datakicktest.testinfastructure.aBookItemViewState
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Test

class MainViewModelTest {

  private val mainModel: ProductFetcher = mockk()
  private val viewModel = MainViewModel(
      mainModel
  )

  @Test
  fun givenProductViewStates_whenAttach_thenEmitProducts() {
    val productViewStates = listOf<ProductViewState>(aBookItemViewState().build())
    every { mainModel.allProducts() } returns Single.just(productViewStates)

    viewModel.onAttach()
    val result = viewModel.getViewState().blockingFirst()

    result.products shouldEqual productViewStates
  }

  @Test
  fun givenProductViewStatesNeverReturns_whenAttach_thenEmitDefaultProducts() {
    every { mainModel.allProducts() } returns Single.never()

    viewModel.onAttach()
    val result = viewModel.getViewState().blockingFirst()

    result.products.size shouldEqual 0
  }
}
