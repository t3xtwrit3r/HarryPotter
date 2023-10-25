package com.mubin.harrypotter.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mubin.harrypotter.R


@BindingAdapter("android:imageUrl")
fun setImageURL(imageView: ImageView, url: String?) {
    try {
        Glide.with(imageView).load(url).placeholder(R.drawable.image_loading_placeholder).error(R.drawable.image_error_placeholder).into(imageView)
    } catch (ignored: Exception) {
    }
}