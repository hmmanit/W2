package com.homalab.android.w2.data.repository.account.datasource

import com.homalab.android.w2.data.entity.Account

interface AccountDataSource {
    suspend fun createAccount(account: Account): Long

    suspend fun deleteAccount(account: Account): Int

    suspend fun updateAccount(account: Account): Int

    suspend fun getAllAccounts(): List<Account>
}