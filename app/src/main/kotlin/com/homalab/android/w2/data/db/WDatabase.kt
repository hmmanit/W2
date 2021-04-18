package com.homalab.android.w2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.homalab.android.w2.data.db.dao.AccountDao
import com.homalab.android.w2.data.db.dao.SpendingDao
import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.model.Spending

@Database(entities = [Spending::class, Account::class], version = 1)
abstract class WDatabase : RoomDatabase() {
    abstract val spendingDao: SpendingDao
    abstract val accountDao: AccountDao
}