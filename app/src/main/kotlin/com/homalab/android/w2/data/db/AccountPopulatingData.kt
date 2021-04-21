package com.homalab.android.w2.data.db

import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.entity.AccountGroup

val accountGroups = listOf(
    AccountGroup(1, "Accounts", "Description", System.currentTimeMillis(), System.currentTimeMillis()),
    AccountGroup(2, "Card", "Description", System.currentTimeMillis(), System.currentTimeMillis()),
    AccountGroup(3, "Debit Card", "Description", System.currentTimeMillis(), System.currentTimeMillis()),
    AccountGroup(4, "Savings", "Description", System.currentTimeMillis(), System.currentTimeMillis())
)

val accounts = listOf(
    Account(0, 1, "Cash", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
    Account(0, 2, "Bank 1", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
    Account(0, 2, "Bank 2", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
    Account(0, 3, "Bank 1", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
    Account(0, 3, "Bank 2", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
    Account(0, 4, "For traveling", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
    Account(0, 4, "For clothes", 0f, System.currentTimeMillis(), System.currentTimeMillis()),
)