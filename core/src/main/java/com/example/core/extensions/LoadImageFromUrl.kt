package com.example.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromUrl(url: String){
    Glide.with(this.context).load(url).into(this)
}