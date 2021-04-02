package com.homanad.android.w2.data.repository.account.datasource

import com.homanad.android.w2.data.db.WDatabase
import com.homanad.android.w2.data.model.Account

class AccountDataSourceImpl(wDatabase: WDatabase) : AccountDataSource {

    private val walletDao = wDatabase.accountDao

    override suspend fun createWallet(walletEntity: Account): Long {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWallet(walletEntity: Account): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateWallet(walletEntity: Account): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Account> {
        TODO("Not yet implemented")
    }
}