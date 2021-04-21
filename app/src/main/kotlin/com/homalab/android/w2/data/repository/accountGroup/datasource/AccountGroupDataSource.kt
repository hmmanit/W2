package com.homalab.android.w2.data.repository.accountGroup.datasource

import com.homalab.android.w2.data.entity.AccountGroup

interface AccountGroupDataSource {
    suspend fun createAccountGroup(accountGroup: AccountGroup): Long

    suspend fun deleteAccountGroup(accountGroup: AccountGroup): Int

    suspend fun updateAccountGroup(accountGroup: AccountGroup): Int

    suspend fun getAllAccountGroups(): List<AccountGroup>
}