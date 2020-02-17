package com.jomo.productecommerce.data.model

import android.graphics.drawable.Drawable

data class Product(
    var title: String? = null,
    var type: String? = null,
    var description: String? = null,
    var price: Int? = null,
    var rating: Int? = null,
    var img: String? = null
)

class ProductView {
    var title: String? = null
    var price: Int? = null
    var img: Drawable? = null
}