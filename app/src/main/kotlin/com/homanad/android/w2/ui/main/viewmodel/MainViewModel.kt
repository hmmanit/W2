package com.homanad.android.w2.ui.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.homanad.android.common.components.vm.BaseViewModel
import com.homanad.android.w2.data.model.WalletData
import com.homanad.android.w2.data.repository.minus.MinusRepository
import com.homanad.android.w2.data.repository.wallet.WalletRepository
import com.homanad.android.w2.ui.main.intent.MainIntent
import com.homanad.android.w2.ui.main.viewstate.MainState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel(
    private val walletRepository: WalletRepository,
    private val minusRepository: MinusRepository
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
                    is MainIntent.CreateWalletIntent -> createWallet(it.walletData)
                    is MainIntent.DeleteWalletIntent -> deleteWallet(it.walletData)
                    is MainIntent.UpdateWalletIntent -> updateWallet(it.walletData)
                }
            }
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Wallets(walletRepository.getAll())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun createWallet(walletData: WalletData) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                walletRepository.createWallet(walletData)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun deleteWallet(walletData: WalletData) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                walletRepository.deleteWallet(walletData)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun updateWallet(walletData: WalletData) {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                walletRepository.updateWallet(walletData)
                MainState.Idle
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

}