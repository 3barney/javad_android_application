package com.jomo.productecommerce.data.model

data class Product(
    var title: String? = null,
    var type: String? = null,
    var description: String? = null,
    var price: Float? = null,
    var rating: Int? = null,
    var img: String? = null
)