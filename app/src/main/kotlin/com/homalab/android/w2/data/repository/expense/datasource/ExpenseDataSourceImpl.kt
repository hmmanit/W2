package com.homalab.android.w2.data.repository.expense.datasource

import com.homalab.android.w2.data.db.dao.ExpenseDao
import com.homalab.android.w2.data.entity.Expense
import javax.inject.Inject

class ExpenseDataSourceImpl @Inject constructor(
    private val expenseDao: ExpenseDao
) : ExpenseDataSource {

    override suspend fun createExpense(expense: Expense): Long {
        return expenseDao.insert(expense)
    }

    override suspend fun deleteExpense(expense: Expense): Int {
        return expenseDao.delete(expense)
    }

    override suspend fun updateExpense(expense: Expense): Int {
        return expenseDao.update(expense)
    }

    override suspend fun getAllExpenses(): List<Expense> {
        return expenseDao.getAllExpenses()
    }
}