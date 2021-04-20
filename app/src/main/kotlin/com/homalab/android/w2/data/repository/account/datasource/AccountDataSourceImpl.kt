package com.homalab.android.w2.data.repository.account.datasource

import com.homalab.android.w2.data.db.dao.AccountDao
import com.homalab.android.w2.data.entity.Account
import javax.inject.Inject

class AccountDataSourceImpl @Inject constructor(private val accountDao: AccountDao) :
    AccountDataSource {

    override suspend fun createAccount(account: Account): Long {
        return accountDao.insert(account)
    }

    override suspend fun deleteAccount(account: Account): Int {
        return accountDao.delete(account)
    }

    override suspend fun updateAccount(account: Account): Int {
        return accountDao.update(account)
    }

    override suspend fun getAllAccounts(): List<Account> {
        return accountDao.getAllAccounts()
    }
}