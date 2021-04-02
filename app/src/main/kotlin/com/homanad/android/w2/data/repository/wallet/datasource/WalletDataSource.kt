package com.homanad.android.w2.data.repository.wallet.datasource

import com.homanad.android.w2.data.model.WalletData

interface WalletDataSource {
    suspend fun createWallet(walletEntity: WalletData): Long

    suspend fun deleteWallet(walletEntity: WalletData): Int

    suspend fun updateWallet(walletEntity: WalletData): Int

    suspend fun getAll(): List<WalletData>
}