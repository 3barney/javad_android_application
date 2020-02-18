package com.jomo.productecommerce.di.modules

import com.jomo.productecommerce.CartActivity
import com.jomo.productecommerce.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun constributesCartActivity(): CartActivity
}