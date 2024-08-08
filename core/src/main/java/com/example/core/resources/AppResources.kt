package com.example.core.resources

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface AppResources  {

    fun getString(@StringRes stringId: Int): String

    fun getDrawable(@DrawableRes resId: Int): Drawable?
}