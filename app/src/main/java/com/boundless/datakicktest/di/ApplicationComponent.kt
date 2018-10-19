package com.boundless.datakicktest.di

import android.app.Application
import com.boundless.datakicktest.MyApplication
import com.boundless.datakicktest.di.modules.AndroidSystemModule
import com.boundless.datakicktest.di.modules.RepositoryModule
import com.boundless.datakicktest.di.modules.PlatformModule
import com.boundless.datakicktest.di.modules.TurtleModule
import com.boundless.datakicktest.di.modules.services.ServiceModule
import com.boundless.datakicktest.di.ui.modules.UiModule
import com.boundless.aardvark.libraryhelpers.dagger.PerApplication
import com.boundless.datakicktest.di.modules.UsecaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@PerApplication
@Component(
    modules = [
      AndroidInjectionModule::class,
      AndroidSystemModule::class,
      TurtleModule::class,
      PlatformModule::class,
      UiModule::class,
      RepositoryModule::class,
      ServiceModule::class,
      UsecaseModule::class
    ]
)
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun provideApplication(application: Application): Builder

    fun build(): ApplicationComponent
  }

  fun inject(application: MyApplication)
}
