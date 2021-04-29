package com.homalab.android.w2.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.homalab.android.w2.data.db.*
import com.homalab.android.w2.data.db.dao.AccountDao
import com.homalab.android.w2.data.db.dao.AccountGroupDao
import com.homalab.android.w2.data.db.dao.CategoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideWDatabase(
        @ApplicationContext context: Context,
        categoryDaoProvider: Provider<CategoryDao>,
        accountGroupDaoProvider: Provider<AccountGroupDao>,
        accountDaoProvider: Provider<AccountDao>
    ) = Room.databaseBuilder(
        context,
        WDatabase::class.java,
        WDatabase::class.java.simpleName
    )
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    categoryDaoProvider.get().insert(expenseCategories)
                    categoryDaoProvider.get().insert(incomeCategories)
                    accountGroupDaoProvider.get().insert(accountGroups)
                    accountDaoProvider.get().insert(accounts)
                }
            }
        })
        .build()

    @Provides
    fun provideExpenseDao(wDatabase: WDatabase) = wDatabase.expenseDao

    @Provides
    fun provideIncomeDao(wDatabase: WDatabase) = wDatabase.incomeDao

    @Provides
    fun provideAccountDao(wDatabase: WDatabase) = wDatabase.accountDao

    @Provides
    fun provideCategoryDao(wDatabase: WDatabase) = wDatabase.categoryDao

    @Provides
    fun provideAccountGroupDao(wDatabase: WDatabase) = wDatabase.accountGroupDao

    @Provides
    fun provideAccountsDao(wDatabase: WDatabase) = wDatabase.accountsDao
}