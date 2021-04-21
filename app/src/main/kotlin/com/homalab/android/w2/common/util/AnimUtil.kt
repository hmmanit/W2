package com.homalab.android.w2.common.util

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.homalab.android.w2.R

object AnimUtil {

    fun getSlideInFromLeftAnimation(context: Context): Animation {
        return AnimationUtils.loadAnimation(context, R.anim.slide_in_from_left)
    }

    fun getSlideInFromRightAnimation(context: Context): Animation {
        return AnimationUtils.loadAnimation(context, R.anim.slide_in_from_right)
    }
}