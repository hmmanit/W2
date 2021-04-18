package com.homalab.android.w2.data.repository.account

import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.repository.account.datasource.AccountDataSource
import javax.inject.Inject

class AccountRepository @Inject constructor(private val accountDataSource: AccountDataSource) {

    suspend fun createWallet(account: Account): Long = accountDataSource.createAccount(account)

    suspend fun deleteWallet(account: Account): Int = accountDataSource.deleteAccount(account)

    suspend fun updateWallet(account: Account): Int = accountDataSource.updateAccount(account)

    suspend fun getAll(): List<Account> = accountDataSource.getAllAccounts()
}