package com.jomo.productecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jomo.productecommerce.data.model.Product
import com.jomo.productecommerce.ui.adapter.ProductAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val productListItem = formatProductItems();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }

    override fun onStart() {
        super.onStart()
        setProductsView();
    }

    private fun setProductsView() {
        products_recyclerview.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = ProductAdapter(this@MainActivity, productListItem)
            adapter!!.notifyDataSetChanged()
        }
    }

    private fun formatProductItems(): List<Product> {
        return listOf(
            Product(
                "Brown eggs", "dairy", "Raw organic brown eggs in a basket",
                28, 4,  "https://user-images.githubusercontent.com/41929050/61567049-13938600-aa33-11e9-9c69-a4184bf8e524.jpeg"
            ),
            Product(
                "Sweet fresh stawberry", "fruit",  "Sweet fresh stawberry on the wooden table",
                29, 4, "https://user-images.githubusercontent.com/41929050/61567053-13938600-aa33-11e9-9780-104fe4019659.png"
            ),
            Product(
                "Asparagus", "vegetable", "Asparagus with ham on the wooden table",
                18, 3, "https://user-images.githubusercontent.com/41929050/61567051-13938600-aa33-11e9-8ae7-0b5c19aafab4.jpeg"
            ),
            Product(
                "Green smoothie", "diary", "Glass of green smoothie over tin surface.",
                17, 2, "https://user-images.githubusercontent.com/41929050/61567054-13938600-aa33-11e9-9163-eec98e239b7a.png"
            ),
            Product(
                "Raw legums", "vegetable", "Raw legums on the wooden table",
                17, 2, "https://user-images.githubusercontent.com/41929050/61567055-142c1c80-aa33-11e9-96ff-9fbac6413625.png"
            ),
            Product(
                "Baking cake", "dairy", "Baking cake in rural kitchen",
                11, 4, "https://user-images.githubusercontent.com/41929050/61567056-142c1c80-aa33-11e9-8682-10065d338145.png"
            ),
            Product(
                "Pesto with basil", "vegetable", "Hazelnut in black ceramic bowl",
                27, 3, "https://user-images.githubusercontent.com/41929050/61567060-142c1c80-aa33-11e9-8188-5a4803844a9e.png"
            ),
            Product(
                "Fresh stawberry", "fruit", "Sweet fresh stawberry on the wooden table",
                28, 4, "https://user-images.githubusercontent.com/41929050/61567059-142c1c80-aa33-11e9-939b-2ecf4492786d.png"
            ),
            Product(
                "Homemade bread", "bakery", "Homemade bread",
                17, 3, "https://user-images.githubusercontent.com/41929050/61567063-14c4b300-aa33-11e9-8515-bcb866da9ea3.png"
            ),
            Product(
                "Fresh tomato", "vegetable", "Fresh tomato juice with basil",
                16, 2, "https://user-images.githubusercontent.com/41929050/61567057-142c1c80-aa33-11e9-9781-9e442418eaab.png"
            )
        );
    }

}
