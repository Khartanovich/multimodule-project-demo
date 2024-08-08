package com.example.core_impl.resources

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.core.resources.AppResources
import javax.inject.Inject

class AppResourcesImpl @Inject constructor(
    private val application: Application
) : AppResources {

    private val resources = application.resources

    override fun getString(@StringRes stringId: Int): String {
        return resources.getString(stringId)
    }

    override fun getDrawable(@DrawableRes resId: Int): Drawable? {
        return ContextCompat.getDrawable(application.applicationContext, resId)
    }
}