package com.jomo.productecommerce

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jomo.productecommerce.data.model.Cart
import com.jomo.productecommerce.ui.adapter.CartAdapter
import com.jomo.productecommerce.ui.view_models.CartViewModel
import com.jomo.productecommerce.ui.view_models.CartViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_cart.*
import javax.inject.Inject

class CartActivity : AppCompatActivity() {

    @Inject
    lateinit var cartViewModelFactory: CartViewModelFactory
    lateinit var cartViewModel: CartViewModel
    var cartItems: List<Cart>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        AndroidInjection.inject(this)

        cartViewModel = ViewModelProviders.of(this, cartViewModelFactory)
            .get(CartViewModel::class.java)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material)
        upArrow?.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)

    }

    override fun onStart() {
        super.onStart()
        cartViewModel.loadCartItems()
        cartViewModel.cartResult().observe(
            this,
            Observer<List<Cart>> {
                cartItems = it
                setProductsView()
                Log.e("SUCCESS", "${it?.size}")
            }
        )

        cartViewModel.cartError().observe(
            this,
            Observer<String> {
                Log.e("ERRRROR", "error ${it}")
            }
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        cartViewModel.disposeElements()
        super.onDestroy()
    }

    private fun setProductsView() {
        if (cartItems != null && cartItems!!.isNotEmpty()) {
            empty_cart.visibility = View.GONE
            cart_recyclerview.apply {
                adapter = CartAdapter(this@CartActivity, cartItems!!, cartViewModel)
                adapter!!.notifyDataSetChanged()
            }
            totals_textView.text = "Totals: ".plus(getTotalsAmount().toString())
        } else {
            empty_cart.visibility = View.VISIBLE
            cart_recyclerview.visibility = View.GONE
        }
    }

    private fun getTotalsAmount(): Int {
        val totals = cartItems!!
            .map { it.quantity.times(it.price) }
            .sum();
        return totals;
    }
}
