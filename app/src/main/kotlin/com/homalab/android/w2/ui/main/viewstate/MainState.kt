package com.homalab.android.w2.ui.main.viewstate

import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.model.Expense

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Accounts(val wallets: List<Account>) : MainState()
    data class Expenses(val expenseList: List<Expense>) : MainState()
    data class Error(val error: String?) : MainState()
}