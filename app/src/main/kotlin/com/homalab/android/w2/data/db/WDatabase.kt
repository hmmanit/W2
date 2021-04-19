package com.homalab.android.w2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.homalab.android.w2.data.db.converter.CategoryConverter
import com.homalab.android.w2.data.db.dao.AccountDao
import com.homalab.android.w2.data.db.dao.CategoryDao
import com.homalab.android.w2.data.db.dao.ExpenseDao
import com.homalab.android.w2.data.model.Account
import com.homalab.android.w2.data.model.Category
import com.homalab.android.w2.data.model.Expense

@Database(entities = [Expense::class, Account::class, Category::class], version = 1)
@TypeConverters(CategoryConverter::class)
abstract class WDatabase : RoomDatabase() {
    abstract val expenseDao: ExpenseDao
    abstract val accountDao: AccountDao
    abstract val categoryDao: CategoryDao
}