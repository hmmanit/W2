package com.homalab.android.w2.ui.pages.home.model

import com.homalab.android.w2.data.model.Expense

data class Activity(
    val date: String,
    val expense: MutableList<Expense> = mutableListOf()
)