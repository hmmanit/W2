package com.homalab.android.w2.ui.main.viewstate

import com.homalab.android.w2.data.entity.Accounts
import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.entity.Expense

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class AccountsReturned(val accounts: List<Accounts>) : MainState()
    data class ExpensesReturned(val expenseList: List<Expense>) : MainState()
    data class CategoriesReturned(val categories: List<Category>) : MainState()
    data class Error(val error: String?) : MainState()
}