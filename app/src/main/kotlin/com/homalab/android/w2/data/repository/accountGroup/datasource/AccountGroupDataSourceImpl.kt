package com.homalab.android.w2.data.repository.accountGroup.datasource

import com.homalab.android.w2.data.db.dao.AccountGroupDao
import com.homalab.android.w2.data.entity.AccountGroup
import javax.inject.Inject

class AccountGroupDataSourceImpl @Inject constructor(
    private val accountGroupDao: AccountGroupDao
) : AccountGroupDataSource {

    override suspend fun createAccountGroup(accountGroup: AccountGroup): Long {
        return accountGroupDao.insert(accountGroup)
    }

    override suspend fun deleteAccountGroup(accountGroup: AccountGroup): Int {
        return accountGroupDao.delete(accountGroup)
    }

    override suspend fun updateAccountGroup(accountGroup: AccountGroup): Int {
        return accountGroupDao.update(accountGroup)
    }

    override suspend fun getAllAccountGroups(): List<AccountGroup> {
        return accountGroupDao.getAccountGroups()
    }
}