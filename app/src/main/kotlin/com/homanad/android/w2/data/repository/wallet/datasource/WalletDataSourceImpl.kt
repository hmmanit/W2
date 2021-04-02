package com.homanad.android.w2.data.repository.wallet.datasource

import com.homanad.android.w2.data.db.WDatabase
import com.homanad.android.w2.data.model.WalletData

class WalletDataSourceImpl(wDatabase: WDatabase) : WalletDataSource {

    private val walletDao = wDatabase.walletDao

    override suspend fun createWallet(walletEntity: WalletData): Long {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWallet(walletEntity: WalletData): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateWallet(walletEntity: WalletData): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<WalletData> {
        TODO("Not yet implemented")
    }
}