package com.homalab.android.w2.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.entity.Expense
import com.homalab.android.w2.data.repository.account.AccountRepository
import com.homalab.android.w2.data.repository.accountGroup.AccountGroupRepository
import com.homalab.android.w2.data.repository.accounts.AccountsRepository
import com.homalab.android.w2.data.repository.category.CategoryRepository
import com.homalab.android.w2.data.repository.expense.ExpenseRepository
import com.homalab.android.w2.data.repository.income.IncomeRepository
import com.homalab.android.w2.ui.main.intent.MainIntent
import com.homalab.android.w2.ui.main.viewstate.MainState
import com.homanad.android.common.components.vm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@ExperimentalCoroutinesApi
class MainViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val expenseRepository: ExpenseRepository,
    private val incomeRepository: IncomeRepository,
    private val categoryRepository: CategoryRepository,
    private val accountGroupRepository: AccountGroupRepository,
    private val accountsRepository: AccountsRepository
) : BaseViewModel() {

    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)

    val state: StateFlow<MainState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.GetAllAccountsIntent -> getAll()
                    is MainIntent.CreateAccountIntent -> createWallet(it.account)
                    is MainIntent.DeleteAccountIntent -> deleteWallet(it.account)
                    is MainIntent.UpdateAccountIntent -> updateWallet(it.account)

                    is MainIntent.GetAllExpensesIntent -> getAllSpending()
                    is MainIntent.CreateExpenseIntent -> createSpending(it.expense)

                    is MainIntent.GetAllCategoriesIntent -> getCategories(it.type)
                }
            }
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.AccountsReturned(accountsRepository.getAccounts())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun createWallet(account: Account) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                accountRepository.createAccount(account)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun deleteWallet(account: Account) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                accountRepository.deleteAccount(account)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun updateWallet(account: Account) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                accountRepository.updateAccount(account)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun getAllSpending() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.ExpensesReturned(expenseRepository.getAllExpenses())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun createSpending(expense: Expense) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                expenseRepository.createExpense(expense)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun getCategories(type: Category.Type) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.CategoriesReturned(categoryRepository.getAllCategories(type.ordinal))
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }
}