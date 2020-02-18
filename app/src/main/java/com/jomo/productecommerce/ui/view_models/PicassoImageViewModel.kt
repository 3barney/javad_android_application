package com.jomo.productecommerce.ui.view_models

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import com.jomo.productecommerce.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

class PicassoImageViewModel(context: Context, imageUrl: String) {

    var IMAGE_URL: String? = null
    var productImage: ObservableField<Drawable>? = null
    private var bindableFieldTarget: BindableFieldTarget? = null

    init {
        this.IMAGE_URL = imageUrl
        productImage = ObservableField<Drawable>()

        bindableFieldTarget = BindableFieldTarget(productImage!!, context.resources)
        Picasso.with(context).load(imageUrl).placeholder(R.drawable.ic_launcher_background)
            .into(bindableFieldTarget)
    }

    inner class BindableFieldTarget(
        private val observableField: ObservableField<Drawable>,
        private val resources: Resources
    ) : Target {
        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
            observableField.set(placeHolderDrawable)
        }

        override fun onBitmapFailed(errorDrawable: Drawable?) {
            observableField.set(errorDrawable)
        }

        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
            observableField.set(BitmapDrawable(resources, bitmap))
        }
    }
}
