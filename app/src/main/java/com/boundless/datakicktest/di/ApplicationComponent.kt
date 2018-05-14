package com.boundless.datakicktest.di

import android.app.Application
import com.boundless.datakicktest.MyApplication
import com.boundless.datakicktest.di.modules.AndroidSystemModule
import com.boundless.datakicktest.di.modules.RepositoryModule
import com.boundless.datakicktest.di.modules.ThreadingModule
import com.boundless.datakicktest.di.modules.TurtleModule
import com.boundless.datakicktest.di.ui.modules.UiModule
import com.boundless.elephant.libraryhelpers.dagger.PerApplication
import com.boundless.risingtides.di.modules.services.ServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@PerApplication
@Component(
    modules = [
      AndroidInjectionModule::class,
      AndroidSystemModule::class,
      TurtleModule::class,
      UiModule::class,
      RepositoryModule::class,
      ThreadingModule::class,
      ServiceModule::class
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
