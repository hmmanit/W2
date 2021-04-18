package com.homalab.android.w2.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.repository.account.AccountRepository
import com.homalab.android.w2.data.repository.spending.SpendingRepository
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
    private val spendingRepository: SpendingRepository
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
                    is MainIntent.GetAllWalletIntent -> getAll()
                    is MainIntent.CreateWalletIntent -> createWallet(it.account)
                    is MainIntent.DeleteWalletIntent -> deleteWallet(it.account)
                    is MainIntent.UpdateWalletIntent -> updateWallet(it.account)
                }
            }
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Wallets(accountRepository.getAll())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun createWallet(account: Account) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                accountRepository.createWallet(account)
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
                accountRepository.deleteWallet(account)
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
                accountRepository.updateWallet(account)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

}