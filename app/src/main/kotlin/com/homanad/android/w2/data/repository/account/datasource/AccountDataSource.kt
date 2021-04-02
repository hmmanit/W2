package com.homanad.android.w2.data.repository.account.datasource

import com.homanad.android.w2.data.model.Account

interface AccountDataSource {
    suspend fun createWallet(walletEntity: Account): Long

    suspend fun deleteWallet(walletEntity: Account): Int

    suspend fun updateWallet(walletEntity: Account): Int

    suspend fun getAll(): List<Account>
}