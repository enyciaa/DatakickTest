package com.boundless.datakicktest.di.ui.components

import com.boundless.datakicktest.di.ui.modules.ActivityScopedModule
import com.boundless.datakicktest.di.ui.modules.ViewModelModule
import com.boundless.datakicktest.ui.MainActivity
import com.boundless.datakicktest.ui.MotherActivity
import com.boundless.aardvark.libraryhelpers.dagger.PerActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityAndroidInjectorModule {

    @PerActivity
    @ContributesAndroidInjector(
            modules = [
                MainActivityModule::class,
                ActivityScopedModule::class,
                ViewModelModule::class
            ]
    )
    fun provideMainActivity(): MainActivity
}

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun provideActivity(activity: MainActivity): MotherActivity

}
