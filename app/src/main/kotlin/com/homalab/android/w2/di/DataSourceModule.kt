package com.homalab.android.w2.di

import com.homalab.android.w2.data.repository.account.datasource.AccountDataSource
import com.homalab.android.w2.data.repository.account.datasource.AccountDataSourceImpl
import com.homalab.android.w2.data.repository.accountGroup.datasource.AccountGroupDataSource
import com.homalab.android.w2.data.repository.accountGroup.datasource.AccountGroupDataSourceImpl
import com.homalab.android.w2.data.repository.accounts.datasource.AccountsDataSource
import com.homalab.android.w2.data.repository.accounts.datasource.AccountsDataSourceImpl
import com.homalab.android.w2.data.repository.category.datasource.CategoryDataSource
import com.homalab.android.w2.data.repository.category.datasource.CategoryDataSourceImpl
import com.homalab.android.w2.data.repository.expense.datasource.ExpenseDataSource
import com.homalab.android.w2.data.repository.expense.datasource.ExpenseDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindExpenseDataSource(spendingDataSourceImpl: ExpenseDataSourceImpl): ExpenseDataSource

    @Binds
    abstract fun bindAccountDataSource(accountDataSourceImpl: AccountDataSourceImpl): AccountDataSource

    @Binds
    abstract fun bindCategoryDataSource(categoryDataSourceImpl: CategoryDataSourceImpl): CategoryDataSource

    @Binds
    abstract fun bindAccountGroupDataSource(accountGroupDataSourceImpl: AccountGroupDataSourceImpl): AccountGroupDataSource

    @Binds
    abstract fun bindAccountsDataSource(accountsDataSourceImpl: AccountsDataSourceImpl): AccountsDataSource
}