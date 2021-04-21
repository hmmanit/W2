package com.homalab.android.w2.data.repository.accounts.datasource

import com.homalab.android.w2.data.entity.Accounts

interface AccountsDataSource {

    suspend fun getAccounts(): List<Accounts>
}