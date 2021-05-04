package com.homalab.android.w2.ui.main.intent

import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.data.entity.Income

sealed class MainIntent {
    object GetAllAccountsIntent : MainIntent()
    data class CreateAccountIntent(val account: Account) : MainIntent()
    data class DeleteAccountIntent(val account: Account) : MainIntent()
    data class UpdateAccountIntent(val account: Account) : MainIntent()

    object GetAllExpensesIntent : MainIntent()
    data class CreateExpenseIntent(val expense: Expense) : MainIntent()
    data class CreateIncomeIntent(val income: Income) : MainIntent()

    data class GetAllCategoriesIntent(val type: Category.Type) : MainIntent()
}