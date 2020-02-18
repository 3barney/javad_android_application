package com.jomo.productecommerce.data.repository

import android.util.Log
import com.jomo.productecommerce.data.model.Cart
import com.jomo.productecommerce.data.source.CartDao
import io.reactivex.Observable
import javax.inject.Inject

class CartRepository @Inject constructor(
    val cartDao: CartDao
) {

    fun addProductToCart(cart: Cart) {
        return cartDao.insertCartItem(cart)
    }

    fun getCartItems(): Observable<List<Cart>> {
        return cartDao
            .queryCart()
            .toObservable()
            .doOnNext {
                Log.e("REPOSITORY DB *** ", it.size.toString())
            }
    }

    fun findProductByName(name: String): Cart {
        return cartDao.findCartItemWithName(name)
    }

    fun updateCartItemd(cart: Cart) {
        return cartDao.updateCartItem(cart)
    }

    fun deleteCartItem(cart: Cart) {
        return cartDao.deleteCartItem(cart)
    }
}
