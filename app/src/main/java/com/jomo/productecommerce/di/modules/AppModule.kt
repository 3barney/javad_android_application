package com.jomo.productecommerce.di.modules

import android.app.Application
import androidx.room.Room
import com.jomo.productecommerce.data.source.Database
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
}