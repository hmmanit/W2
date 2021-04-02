package com.homanad.android.w2.data.repository.account

import com.homanad.android.w2.data.model.Account
import com.homanad.android.w2.data.repository.account.datasource.AccountDataSource

class AccountRepositoryImpl(private val accountDataSource: AccountDataSource) : AccountRepository {

    override suspend fun createWallet(account: Account): Long =
        accountDataSource.createWallet(account)

    override suspend fun deleteWallet(account: Account): Int =
        accountDataSource.deleteWallet(account)

    override suspend fun updateWallet(account: Account): Int =
        accountDataSource.updateWallet(account)

    override suspend fun getAll(): List<Account> = accountDataSource.getAll()
}