package com.jomo.productecommerce.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jomo.productecommerce.data.model.Cart
import io.reactivex.Single

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun queryCart(): Single<List<Cart>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartItem(cart: Cart)

    // TODO: Update and delete
}