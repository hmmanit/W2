package com.homalab.android.w2.ui.main.viewstate

import com.homalab.android.w2.data.entity.Accounts
import com.homalab.android.w2.data.entity.Expense

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class AccountsReturned(val accounts: List<Accounts>) : MainState()
    data class Expenses(val expenseList: List<Expense>) : MainState()
    data class Error(val error: String?) : MainState()
}