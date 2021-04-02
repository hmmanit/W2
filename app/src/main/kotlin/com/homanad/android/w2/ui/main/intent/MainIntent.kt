package com.homanad.android.w2.ui.main.intent

import com.homanad.android.w2.data.model.WalletData

sealed class MainIntent {
    object GetAllWalletIntent : MainIntent()
    data class CreateWalletIntent(val walletData: WalletData) : MainIntent()
    data class DeleteWalletIntent(val walletData: WalletData) : MainIntent()
    data class UpdateWalletIntent(val walletData: WalletData) : MainIntent()
}