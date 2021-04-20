package com.homalab.android.w2.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.homalab.android.w2.data.db.WDatabase
import com.homalab.android.w2.data.db.categories
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
    fun provideWDatabase(@ApplicationContext context: Context, categoryDaoProvider: Provider<CategoryDao>) = Room.databaseBuilder(
        context,
        WDatabase::class.java,
        WDatabase::class.java.simpleName
    )
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    categoryDaoProvider.get().insert(categories)
                }
            }
        })
        .build()

    @Provides
    fun provideExpenseDao(wDatabase: WDatabase) = wDatabase.expenseDao

    @Provides
    fun provideAccountDao(wDatabase: WDatabase) = wDatabase.accountDao

    @Provides
    fun provideCategoryDao(wDatabase: WDatabase) = wDatabase.categoryDao
}