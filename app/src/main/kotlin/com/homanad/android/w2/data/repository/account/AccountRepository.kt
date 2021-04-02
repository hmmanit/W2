package com.homanad.android.w2.data.repository.account

import com.homanad.android.w2.data.model.Account
import com.homanad.android.w2.data.repository.account.datasource.AccountDataSource
import javax.inject.Inject

class AccountRepository @Inject constructor(private val accountDataSource: AccountDataSource) {

    suspend fun createWallet(account: Account): Long = accountDataSource.createWallet(account)

    suspend fun deleteWallet(account: Account): Int = accountDataSource.deleteWallet(account)

    suspend fun updateWallet(account: Account): Int = accountDataSource.updateWallet(account)

    suspend fun getAll(): List<Account> = accountDataSource.getAll()
}