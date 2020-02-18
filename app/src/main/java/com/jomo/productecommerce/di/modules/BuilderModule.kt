package com.jomo.productecommerce.di.modules

import com.jomo.productecommerce.ui.activity.CartActivity
import com.jomo.productecommerce.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun constributesCartActivity(): CartActivity
}
