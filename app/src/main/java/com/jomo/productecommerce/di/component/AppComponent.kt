package com.jomo.productecommerce.di.component

import com.jomo.productecommerce.MainApplication
import com.jomo.productecommerce.di.modules.AppModule
import com.jomo.productecommerce.di.modules.BuilderModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, AppModule::class, BuilderModule::class)
)
interface AppComponent {
    fun inject(app: MainApplication)
}
