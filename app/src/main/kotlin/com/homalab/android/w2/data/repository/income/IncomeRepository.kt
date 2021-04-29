package com.homalab.android.w2.data.repository.income

import com.homalab.android.w2.data.entity.Income
import com.homalab.android.w2.data.repository.income.datasource.IncomeDataSource
import javax.inject.Inject

class IncomeRepository @Inject constructor(private val incomeDataSource: IncomeDataSource) {

    suspend fun createIncome(income: Income): Long = incomeDataSource.createIncome(income)

    suspend fun deleteIncome(income: Income): Int = incomeDataSource.deleteIncome(income)

    suspend fun updateIncome(income: Income): Int = incomeDataSource.updateIncome(income)

    suspend fun getAllIncomes(): List<Income> = incomeDataSource.getAllIncomes()
}