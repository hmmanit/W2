package com.homalab.android.w2.data.repository.expense

import com.homalab.android.w2.data.model.Expense
import com.homalab.android.w2.data.repository.expense.datasource.ExpenseDataSource
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDataSource: ExpenseDataSource) {

    suspend fun createSpending(expense: Expense): Long =
        expenseDataSource.createSpending(expense)

    suspend fun deleteSpending(expense: Expense): Int =
        expenseDataSource.deleteSpending(expense)

    suspend fun updateSpending(expense: Expense): Int =
        expenseDataSource.updateSpending(expense)

    suspend fun getAll(): List<Expense> = expenseDataSource.getAllSpending()
}