package com.jomo.productecommerce.data.source

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")

}