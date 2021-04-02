package com.homanad.android.w2.data.repository.account.datasource

import com.homanad.android.w2.data.model.Account

interface AccountDataSource {
    suspend fun createAccount(account: Account): Long

    suspend fun deleteAccount(account: Account): Int

    suspend fun updateAccount(account: Account): Int

    suspend fun getAllAccounts(): List<Account>
}