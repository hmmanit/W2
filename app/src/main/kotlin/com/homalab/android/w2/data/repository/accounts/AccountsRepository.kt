package com.homalab.android.w2.data.repository.accounts

import com.homalab.android.w2.data.entity.Accounts
import com.homalab.android.w2.data.repository.accounts.datasource.AccountsDataSource
import javax.inject.Inject

class AccountsRepository @Inject constructor(private val accountsDataSource: AccountsDataSource) {

    suspend fun getAccounts(): List<Accounts> {
        return accountsDataSource.getAccounts()
    }
}