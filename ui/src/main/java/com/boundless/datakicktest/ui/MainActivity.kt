package com.boundless.datakicktest.ui

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.boundless.aardvark.extensions.makeGone
import com.boundless.aardvark.extensions.makeVisible
import com.boundless.datakicktest.common.ui.states.BookItemViewState
import com.boundless.datakicktest.common.ui.states.FoodItemViewState
import com.boundless.datakicktest.common.ui.states.MainViewState
import com.boundless.datakicktest.common.ui.states.ProductViewState
import com.boundless.datakicktest.common.ui.viewmodels.LifecycleReceiver
import com.boundless.datakicktest.common.ui.viewmodels.MainViewModel
import com.boundless.datakicktest.ui.databinding.MainActivityBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import javax.inject.Inject

class MainActivity : MotherActivity() {

  @Inject lateinit var viewModel: MainViewModel

  private lateinit var binding: MainActivityBinding

  private val listItemBinding: OnItemBind<ProductViewState> = OnItemBind { itemBinding, _, item ->
    when (item) {
      is FoodItemViewState -> itemBinding.set(BR.viewState, R.layout.foods_item)
      is BookItemViewState -> itemBinding.set(BR.viewState, R.layout.book_item)
      else -> { /* Do nothing */ }
    }
  }

  companion object {
    fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
    binding.listItemBinding = listItemBinding
    setSupportActionBar(binding.toolbar)

    binding.filterByBooks.setOnClickListener { viewModel.filterByBooks() }
    binding.filterByFood.setOnClickListener { viewModel.filterByFood() }
    binding.showAll.setOnClickListener { viewModel.showAllProducts() }
  }

  override fun provideLifecycleReceivers(): List<LifecycleReceiver> = listOf(viewModel)

  override fun onResume() {
    super.onResume()
    viewModel.viewStateUpdatedCallback = this::renderViewState
  }

  private fun renderViewState(mainViewState: MainViewState) {
    binding.viewState = mainViewState
  }
}
