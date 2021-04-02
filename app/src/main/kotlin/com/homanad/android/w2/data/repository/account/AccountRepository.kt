package com.homanad.android.w2.data.repository.account

import com.homanad.android.w2.data.model.Account

interface AccountRepository {

    suspend fun createWallet(account: Account): Long

    suspend fun deleteWallet(account: Account): Int

    suspend fun updateWallet(account: Account): Int

    suspend fun getAll(): List<Account>
}