package com.jomo.productecommerce.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jomo.productecommerce.R
import com.jomo.productecommerce.data.model.Cart
import com.jomo.productecommerce.data.model.CartModel
import com.jomo.productecommerce.databinding.CartProductItemBinding
import com.jomo.productecommerce.ui.view_models.CartViewModel
import com.jomo.productecommerce.ui.view_models.PicassoImageViewModel

class CartAdapter(
    private val context: Context,
    private val cartItems: List<Cart>,
    private val cartViewModel: CartViewModel
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        val mBinding: CartProductItemBinding = DataBindingUtil.bind(itemView)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cart_product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = cartItems[position]
        var cartModel = CartModel()
        cartModel.name = cartItem.name
        cartModel.price = cartItem.price
        cartModel.quantity = cartItem.quantity
        cartModel.total = cartItem.quantity.times(cartItem.price)

        val imageViewModel = PicassoImageViewModel(context, cartItem.img)
        cartModel.img = imageViewModel.productImage?.get()


        holder.mBinding.decreaseQuantity.setOnClickListener {
            cartViewModel.decreaseQuantity(cartItem)
            notifyItemChanged(position)
        }

        holder.mBinding.increaseQuantity.setOnClickListener {
            cartViewModel.increaseQuantity(cartItem)
            notifyItemChanged(position)
        }

        holder.mBinding.data = cartModel
        holder.mBinding.executePendingBindings()
    }
}