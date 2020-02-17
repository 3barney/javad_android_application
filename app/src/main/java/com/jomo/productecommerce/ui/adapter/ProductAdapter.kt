package com.jomo.productecommerce.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jomo.productecommerce.R
import com.jomo.productecommerce.data.model.Product
import com.jomo.productecommerce.data.model.ProductView
import com.jomo.productecommerce.databinding.ProductItemViewBinding
import com.jomo.productecommerce.ui.view_models.ProductViewModel

class ProductAdapter(
    private val mContext: Context,
    private val productList: List<Product>
):
        RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.product_item_view, parent, false);
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        var productView = ProductView()
        productView.price = product.price
        productView.title = product.title

        val productViewModel = ProductViewModel(mContext, product.img!!)
        productView.img = productViewModel.productImage?.get()

        holder.mBinding.vm = productView
        holder.mBinding.executePendingBindings()
    }

    inner class ViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val mBinding: ProductItemViewBinding = DataBindingUtil.bind(itemView)!!

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val itemName = mBinding.productName.text.toString();
            // TODO: Add viewModel here
        }
    }
}