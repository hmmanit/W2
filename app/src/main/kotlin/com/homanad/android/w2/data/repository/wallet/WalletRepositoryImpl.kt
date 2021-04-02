package com.homanad.android.w2.data.repository.wallet

import com.homanad.android.w2.data.model.WalletData
import com.homanad.android.w2.data.repository.wallet.datasource.WalletDataSource

class WalletRepositoryImpl(private val walletDataSource: WalletDataSource) : WalletRepository {

    override suspend fun createWallet(walletData: WalletData): Long =
        walletDataSource.createWallet(walletData)

    override suspend fun deleteWallet(walletData: WalletData): Int =
        walletDataSource.deleteWallet(walletData)

    override suspend fun updateWallet(walletData: WalletData): Int =
        walletDataSource.updateWallet(walletData)

    override suspend fun getAll(): List<WalletData> = walletDataSource.getAll()
}