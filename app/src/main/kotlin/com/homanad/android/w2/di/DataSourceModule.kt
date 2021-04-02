package com.homanad.android.w2.di

import com.homanad.android.w2.data.repository.account.datasource.AccountDataSource
import com.homanad.android.w2.data.repository.account.datasource.AccountDataSourceImpl
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSource
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindSpendingDataSource(spendingDataSourceImpl: SpendingDataSourceImpl): SpendingDataSource

    @Binds
    abstract fun bindAccountDataSource(accountDataSourceImpl: AccountDataSourceImpl): AccountDataSource
}