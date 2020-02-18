package com.jomo.productecommerce.ui.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jomo.productecommerce.data.model.Cart
import com.jomo.productecommerce.data.repository.CartRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CartViewModel @Inject constructor(private val cartRepository: CartRepository): ViewModel() {

    private val result: MutableLiveData<List<Cart>> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()
    lateinit var disposableObserver: DisposableObserver<List<Cart>>

    fun cartResult(): LiveData<List<Cart>> { return result }
    fun cartError(): LiveData<String> { return error }

    fun loadCartItems() {
        disposableObserver = object : DisposableObserver<List<Cart>>() {
            override fun onComplete() {
            }

            override fun onNext(t: List<Cart>) {
                result.postValue(t)
            }

            override fun onError(e: Throwable) {
                error.postValue(e.message)
            }
        }

        cartRepository
            .getCartItems()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(disposableObserver)
    }

    fun addProductToCart(cart: Cart) {
        var productItem: Cart = cartRepository.findProductByName(cart.name)
        if (productItem == null) {
            return cartRepository.addProductToCart(cart)
        } else {
            productItem.quantity += 1 ;
            return cartRepository.updateCartItemd(productItem);
        }
    }

    fun disposeElements() {
        if(null != disposableObserver && !disposableObserver.isDisposed) disposableObserver.dispose()
    }

    fun decreaseQuantity(cartItem: Cart) {
        if (cartItem.quantity == 1) {
            return cartRepository.deleteCartItem(cartItem)
        }

        cartItem.quantity -= 1;
        return cartRepository.updateCartItemd(cartItem)
    }

    fun increaseQuantity(cartItem: Cart) {
        cartItem.quantity += 1
        return cartRepository.updateCartItemd(cartItem)
    }

}