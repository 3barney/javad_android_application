package com.jomo.productecommerce.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jomo.productecommerce.data.model.Cart
import io.reactivex.Single

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun queryCart(): Single<List<Cart>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCartItem(cart: Cart)

    @Update
    fun updateCartItem(cart: Cart)

    @Delete
    fun deleteCartItem(cart: Cart)

    @Query("SELECT * FROM cart WHERE name LIKE :search")
    fun findCartItemWithName(search: String): Cart
}
