package com.jomo.productecommerce.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jomo.productecommerce.R
import com.jomo.productecommerce.data.model.Cart
import com.jomo.productecommerce.data.model.Product
import com.jomo.productecommerce.data.model.ProductView
import com.jomo.productecommerce.databinding.ProductItemViewBinding
import com.jomo.productecommerce.ui.view_models.CartViewModel
import com.jomo.productecommerce.ui.view_models.PicassoImageViewModel

class ProductAdapter(
    private val mContext: Context,
    private val productList: List<Product>,
    private val cartViewModel: CartViewModel
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.product_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        var productView = ProductView()
        productView.price = product.price
        productView.title = product.title

        val productViewModel = PicassoImageViewModel(mContext, product.img!!)
        productView.img = productViewModel.productImage?.get()
        // notifyItemChanged(position)

        holder.mBinding.vm = productView
        holder.mBinding.executePendingBindings()
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val mBinding: ProductItemViewBinding = DataBindingUtil.bind(itemView)!!

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val itemName = mBinding.productName.text.toString()
            lateinit var p: Product

            productList
                .asSequence()
                .filter { it.title.equals(itemName, true) }
                .forEach { p = it }

            var cart = Cart(img = p.img!!, name = p.title!!, quantity = 1, price = p.price!!)
            cartViewModel.addProductToCart(cart)
            Toast.makeText(view?.context, "Added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}
