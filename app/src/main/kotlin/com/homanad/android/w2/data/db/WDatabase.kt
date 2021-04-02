package com.homanad.android.w2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.homanad.android.w2.data.db.dao.AccountDao
import com.homanad.android.w2.data.db.dao.SpendingDao
import com.homanad.android.w2.data.model.Account
import com.homanad.android.w2.data.model.Spending

@Database(entities = [Spending::class, Account::class], version = 1)
abstract class WDatabase : RoomDatabase() {
    abstract val spendingDao: SpendingDao
    abstract val accountDao: AccountDao
}