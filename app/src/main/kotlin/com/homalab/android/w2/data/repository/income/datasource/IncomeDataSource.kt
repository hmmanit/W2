package com.homalab.android.w2.data.repository.income.datasource

import com.homalab.android.w2.data.entity.Income

interface IncomeDataSource {
    suspend fun createIncome(income: Income): Long

    suspend fun deleteIncome(income: Income): Int

    suspend fun updateIncome(income: Income): Int

    suspend fun getAllIncomes(): List<Income>
}