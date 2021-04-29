package com.homalab.android.w2.ui.pages.log.viewmodel

import androidx.lifecycle.viewModelScope
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.data.entity.Income
import com.homalab.android.w2.data.repository.expense.ExpenseRepository
import com.homalab.android.w2.data.repository.income.IncomeRepository
import com.homalab.android.w2.ui.pages.log.intent.LogIntent
import com.homalab.android.w2.ui.pages.log.viewstate.LogState
import com.homanad.android.common.components.vm.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LogViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository,
    private val incomeRepository: IncomeRepository
) : BaseViewModel() {

    val userIntent = Channel<LogIntent>(Channel.UNLIMITED)

    private val _state = MutableStateFlow<LogState>(LogState.Idle)
    val state: StateFlow<LogState>
        get() = _state

    init {
        handleUserIntent()
    }

    private fun handleUserIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is LogIntent.CreateExpense -> {
                        createExpense(it.expense)
                    }
                    is LogIntent.CreateIncome -> {
                        createIncome(it.income)
                    }
                }
            }
        }
    }

    private fun createExpense(expense: Expense) {
        viewModelScope.launch {
            _state.value = LogState.Loading
            _state.value = try {
                LogState.ExpenseCreated(expenseRepository.createExpense(expense))
            } catch (e: Exception) {
                LogState.Error(e.localizedMessage ?: "Unknown Error")
            }
            _state.value = LogState.Idle
        }
    }

    private fun createIncome(income: Income) {
        viewModelScope.launch {
            _state.value = LogState.Loading
            _state.value = try {
                LogState.IncomeCreated(incomeRepository.createIncome(income))
            } catch (e: Exception) {
                LogState.Error(e.localizedMessage ?: "Unknown Error")
            }
            _state.value = LogState.Idle
        }
    }
}