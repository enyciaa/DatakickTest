package com.boundless.datakicktest.ui

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.boundless.datakicktest.common.ui.viewmodels.LifecycleReceiver
import com.boundless.datakicktest.common.ui.viewmodels.MainViewModel
import com.boundless.datakicktest.common.ui.viewmodels.MainViewState
import com.boundless.datakicktest.ui.databinding.MainActivityBinding
import javax.inject.Inject

class MainActivity : MotherActivity() {

  @Inject lateinit var viewModel: MainViewModel

  private lateinit var binding: MainActivityBinding

  companion object {
    fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
    binding.viewModel = viewModel
    setSupportActionBar(binding.toolbar)
  }

  override fun provideLifecycleReceivers(): List<LifecycleReceiver> = listOf(viewModel)

  override fun onResume() {
    super.onResume()
    viewModel.getViewState()
        .subscribe(
            { renderViewState(it) },
            {}
        )
  }

  private fun renderViewState(mainViewState: MainViewState) {
    binding.viewState = mainViewState
  }
}
