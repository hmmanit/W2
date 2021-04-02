package com.homanad.android.w2.ui.main.viewstate

import com.homanad.android.w2.data.model.Spending
import com.homanad.android.w2.data.model.Account

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Wallets(val wallets: List<Account>) : MainState()
    data class Minuses(val wallets: List<Spending>) : MainState()
    data class Error(val error: String?) : MainState()
}