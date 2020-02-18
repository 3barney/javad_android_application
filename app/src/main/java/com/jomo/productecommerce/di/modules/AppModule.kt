package com.jomo.productecommerce.di.modules

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.jomo.productecommerce.data.source.CartDao
import com.jomo.productecommerce.data.source.Database
import com.jomo.productecommerce.ui.view_models.CartViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideProductDatabase(app: Application): Database =
        Room.databaseBuilder(app, Database::class.java, "product_ecommerce_db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCartDao(database: Database): CartDao = database.cartDao()

    @Provides
    fun providesCartViewModelFactory(factory: CartViewModelFactory):
            ViewModelProvider.Factory = factory
}
