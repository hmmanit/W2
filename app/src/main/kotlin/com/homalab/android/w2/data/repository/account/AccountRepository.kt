package com.homalab.android.w2.data.repository.account

import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.repository.account.datasource.AccountDataSource
import javax.inject.Inject

class AccountRepository @Inject constructor(private val accountDataSource: AccountDataSource) {

    suspend fun createAccount(account: Account): Long = accountDataSource.createAccount(account)

    suspend fun deleteAccount(account: Account): Int = accountDataSource.deleteAccount(account)

    suspend fun updateAccount(account: Account): Int = accountDataSource.updateAccount(account)

    suspend fun getAllAccounts(): List<Account> = accountDataSource.getAllAccounts()
}