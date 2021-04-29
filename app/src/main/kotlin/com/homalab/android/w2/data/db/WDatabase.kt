package com.homalab.android.w2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.homalab.android.w2.data.db.converter.CategoryConverter
import com.homalab.android.w2.data.db.dao.*
import com.homalab.android.w2.data.entity.*

@Database(
    entities = [Expense::class, Income::class, Account::class, AccountGroup::class, Category::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(CategoryConverter::class)
abstract class WDatabase : RoomDatabase() {
    abstract val expenseDao: ExpenseDao
    abstract val incomeDao: IncomeDao
    abstract val accountDao: AccountDao
    abstract val categoryDao: CategoryDao
    abstract val accountGroupDao: AccountGroupDao
    abstract val accountsDao: AccountsDao
}