package com.jomo.productecommerce.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jomo.productecommerce.data.model.Cart

@Database(entities = [Cart::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun cartDao(): CartDao
}
