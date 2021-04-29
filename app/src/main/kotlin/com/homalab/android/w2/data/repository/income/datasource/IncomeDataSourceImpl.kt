package com.homalab.android.w2.data.repository.income.datasource

import com.homalab.android.w2.data.db.dao.IncomeDao
import com.homalab.android.w2.data.entity.Income
import javax.inject.Inject

class IncomeDataSourceImpl @Inject constructor(
    private val incomeDao: IncomeDao
) : IncomeDataSource {

    override suspend fun createIncome(income: Income): Long {
        return incomeDao.insert(income)
    }

    override suspend fun deleteIncome(income: Income): Int {
        return incomeDao.delete(income)
    }

    override suspend fun updateIncome(income: Income): Int {
        return incomeDao.update(income)
    }

    override suspend fun getAllIncomes(): List<Income> {
        return incomeDao.getAllIncomes()
    }
}