package com.homalab.android.w2.data.repository.expense.datasource

import com.homalab.android.w2.data.db.dao.ExpenseDao
import com.homalab.android.w2.data.model.Expense
import javax.inject.Inject

class ExpenseDataSourceImpl @Inject constructor(private val expenseDao: ExpenseDao) :
    ExpenseDataSource {

    override suspend fun createSpending(expense: Expense): Long {
        return expenseDao.insert(expense)
    }

    override suspend fun deleteSpending(expense: Expense): Int {
        return expenseDao.delete(expense)
    }

    override suspend fun updateSpending(expense: Expense): Int {
        return expenseDao.update(expense)
    }

    override suspend fun getAllSpending(): List<Expense> {
        return expenseDao.getAllSpending()
    }
}