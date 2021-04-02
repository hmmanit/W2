package com.homanad.android.w2.di

import android.content.Context
import com.homanad.android.w2.data.db.WDatabase
import com.homanad.android.w2.data.repository.minus.MinusRepository
import com.homanad.android.w2.data.repository.minus.MinusRepositoryImpl
import com.homanad.android.w2.data.repository.minus.datasource.MinusDataSource
import com.homanad.android.w2.data.repository.minus.datasource.MinusDataSourceImpl
import com.homanad.android.w2.data.repository.wallet.WalletRepository
import com.homanad.android.w2.data.repository.wallet.WalletRepositoryImpl
import com.homanad.android.w2.data.repository.wallet.datasource.WalletDataSource
import com.homanad.android.w2.data.repository.wallet.datasource.WalletDataSourceImpl

object Injector {

    @Synchronized
    fun provideWDatabase(context: Context): WDatabase {
        return WDatabase.getInstance(context)
    }

    @Synchronized
    fun provideWalletDataSource(context: Context): WalletDataSource {
        return WalletDataSourceImpl(provideWDatabase(context))
    }

    @Synchronized
    fun provideWalletRepository(context: Context): WalletRepository {
        return WalletRepositoryImpl(provideWalletDataSource(context))
    }

    @Synchronized
    fun provideMinusDataSource(context: Context): MinusDataSource {
        return MinusDataSourceImpl(provideWDatabase(context))
    }

    @Synchronized
    fun provideMinusRepository(context: Context): MinusRepository {
        return MinusRepositoryImpl(provideMinusDataSource(context))
    }
}