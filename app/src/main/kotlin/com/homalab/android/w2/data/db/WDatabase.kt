package com.homalab.android.w2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.homalab.android.w2.data.db.converter.CategoryConverter
import com.homalab.android.w2.data.db.dao.*
import com.homalab.android.w2.data.entity.Account
import com.homalab.android.w2.data.entity.AccountGroup
import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.entity.Expense

@Database(
    entities = [Expense::class, Account::class, AccountGroup::class, Category::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(CategoryConverter::class)
abstract class WDatabase : RoomDatabase() {
    abstract val expenseDao: ExpenseDao
    abstract val accountDao: AccountDao
    abstract val categoryDao: CategoryDao
    abstract val accountGroupDao: AccountGroupDao
    abstract val accountsDao: AccountsDao
}