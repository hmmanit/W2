package com.homalab.android.w2.ui.main.intent

import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.model.Expense

sealed class MainIntent {
    object GetAllAccountsIntent : MainIntent()
    data class CreateAccountIntent(val account: Account) : MainIntent()
    data class DeleteAccountIntent(val account: Account) : MainIntent()
    data class UpdateAccountIntent(val account: Account) : MainIntent()

    object GetAllExpensesIntent : MainIntent()
    data class CreateExpenseIntent(val expense: Expense) : MainIntent()
}