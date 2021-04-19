package com.homalab.android.w2.di

import android.content.Context
import androidx.room.Room
import com.homalab.android.w2.data.db.WDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideWDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        WDatabase::class.java,
        WDatabase::class.java.simpleName
    ).build()

    @Provides
    fun provideExpenseDao(wDatabase: WDatabase) = wDatabase.expenseDao

    @Provides
    fun provideAccountDao(wDatabase: WDatabase) = wDatabase.accountDao

    @Provides
    fun provideCategoryDao(wDatabase: WDatabase) = wDatabase.categoryDao
}