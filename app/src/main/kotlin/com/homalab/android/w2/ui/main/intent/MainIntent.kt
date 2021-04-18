package com.homalab.android.w2.ui.main.intent

import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.model.Spending

sealed class MainIntent {
    object GetAllWalletIntent : MainIntent()
    data class CreateWalletIntent(val account: Account) : MainIntent()
    data class DeleteWalletIntent(val account: Account) : MainIntent()
    data class UpdateWalletIntent(val account: Account) : MainIntent()

    object GetAllSpendingIntent : MainIntent()
    data class CreateSpendingIntent(val spending: Spending) : MainIntent()
}