package com.homalab.android.w2.data.repository.accounts.datasource

import com.homalab.android.w2.data.db.dao.AccountsDao
import com.homalab.android.w2.data.entity.Accounts
import javax.inject.Inject

class AccountsDataSourceImpl @Inject constructor(
    private val accountsDao: AccountsDao
) : AccountsDataSource {

    override suspend fun getAccounts(): List<Accounts> {
        return accountsDao.getAccounts()
    }
}