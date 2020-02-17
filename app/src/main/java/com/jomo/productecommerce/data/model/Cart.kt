package com.jomo.productecommerce.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class Cart (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val img: String,
    val name: String,
    val quantity: Int,
    val price: Int
)