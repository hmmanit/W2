package com.homalab.android.w2.data.repository.accountGroup

import com.homalab.android.w2.data.entity.AccountGroup
import com.homalab.android.w2.data.repository.accountGroup.datasource.AccountGroupDataSource
import javax.inject.Inject

class AccountGroupRepository @Inject constructor(private val accountGroupDataSource: AccountGroupDataSource) {

    suspend fun createAccountGroup(accountGroup: AccountGroup): Long {
        return accountGroupDataSource.createAccountGroup(accountGroup)
    }

    suspend fun deleteAccountGroup(accountGroup: AccountGroup): Int {
        return accountGroupDataSource.deleteAccountGroup(accountGroup)
    }

    suspend fun updateAccountGroup(accountGroup: AccountGroup): Int {
        return accountGroupDataSource.updateAccountGroup(accountGroup)
    }

    suspend fun getAllAccountGroups(): List<AccountGroup> {
        return accountGroupDataSource.getAllAccountGroups()
    }
}