package com.homanad.android.w2.ui.main.viewstate

import com.homanad.android.w2.data.model.MinusData
import com.homanad.android.w2.data.model.WalletData

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Wallets(val wallets: List<WalletData>) : MainState()
    data class Minuses(val wallets: List<MinusData>) : MainState()
    data class Error(val error: String?) : MainState()
}