package com.homalab.android.w2.ui.pages.home.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.homalab.android.w2.R

enum class AnswerType(@DrawableRes val icon: Int, @StringRes val title: Int, @StringRes val description: Int) {
    PAY(R.drawable.ic_home, R.string.app_name, R.string.appbar_scrolling_view_behavior),
    TEST1(R.drawable.ic_home, R.string.app_name, R.string.appbar_scrolling_view_behavior),
    TEST2(R.drawable.ic_home, R.string.app_name, R.string.appbar_scrolling_view_behavior),
    TEST3(R.drawable.ic_home, R.string.app_name, R.string.appbar_scrolling_view_behavior),
    TEST4(R.drawable.ic_home, R.string.app_name, R.string.appbar_scrolling_view_behavior),
}
