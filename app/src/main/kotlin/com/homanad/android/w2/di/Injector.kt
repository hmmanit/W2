package com.homanad.android.w2.di

import android.content.Context
import com.homanad.android.w2.data.db.WDatabase
import com.homanad.android.w2.data.repository.spending.SpendingRepository
import com.homanad.android.w2.data.repository.spending.SpendingRepositoryImpl
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSource
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSourceImpl
import com.homanad.android.w2.data.repository.account.AccountRepository
import com.homanad.android.w2.data.repository.account.AccountRepositoryImpl
import com.homanad.android.w2.data.repository.account.datasource.AccountDataSource
import com.homanad.android.w2.data.repository.account.datasource.AccountDataSourceImpl

object Injector {

    @Synchronized
    fun provideWDatabase(context: Context): WDatabase {
        return WDatabase.getInstance(context)
    }

    @Synchronized
    fun provideWalletDataSource(context: Context): AccountDataSource {
        return AccountDataSourceImpl(provideWDatabase(context))
    }

    @Synchronized
    fun provideWalletRepository(context: Context): AccountRepository {
        return AccountRepositoryImpl(provideWalletDataSource(context))
    }

    @Synchronized
    fun provideMinusDataSource(context: Context): SpendingDataSource {
        return SpendingDataSourceImpl(provideWDatabase(context))
    }

    @Synchronized
    fun provideMinusRepository(context: Context): SpendingRepository {
        return SpendingRepositoryImpl(provideMinusDataSource(context))
    }
}