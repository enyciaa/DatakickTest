package com.boundless.datakicktest.di.ui.modules

import com.boundless.datakicktest.di.ui.components.MainActivityAndroidInjectorModule
import dagger.Module

@Module(
    includes = [
        MainActivityAndroidInjectorModule::class
    ]
)
class UiModule