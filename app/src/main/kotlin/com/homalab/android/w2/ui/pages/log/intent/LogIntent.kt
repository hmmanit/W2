package com.homalab.android.w2.ui.pages.log.intent

import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.data.entity.Income

sealed class LogIntent {
    data class CreateExpense(val expense: Expense) : LogIntent()
    data class CreateIncome(val income: Income) : LogIntent()
}