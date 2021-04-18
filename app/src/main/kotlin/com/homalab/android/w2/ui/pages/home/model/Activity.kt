package com.homalab.android.w2.ui.pages.home.model

import com.homalab.android.w2.data.model.Spending

data class Activity(
    val date: String,
    val spending: MutableList<Spending> = mutableListOf()
) {

    override fun equals(other: Any?): Boolean {
        return date == (other as Activity).date
    }

    override fun hashCode(): Int {
        return 1
    }
}