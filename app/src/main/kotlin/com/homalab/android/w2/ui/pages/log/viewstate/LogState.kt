package com.homalab.android.w2.ui.pages.log.viewstate

sealed class LogState {
    object Idle : LogState()
    object Loading : LogState()
    data class Error(val error: String) : LogState()
    data class ExpenseCreated(val id: Long) : LogState()
    data class IncomeCreated(val id: Long) : LogState()
}