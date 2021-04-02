package com.homanad.android.w2.data.repository.wallet

import com.homanad.android.w2.data.model.WalletData

interface WalletRepository {

    suspend fun createWallet(walletData: WalletData): Long

    suspend fun deleteWallet(walletData: WalletData): Int

    suspend fun updateWallet(walletData: WalletData): Int

    suspend fun getAll(): List<WalletData>
}