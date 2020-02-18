package com.jomo.productecommerce.ui.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject

class CartViewModelFactory @Inject constructor(
    private val cartViewModel: CartViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java!!)) {
            return cartViewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
