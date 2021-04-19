package com.homalab.android.w2.data.repository.expense

import com.homalab.android.w2.data.model.Expense
import com.homalab.android.w2.data.repository.expense.datasource.ExpenseDataSource
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDataSource: ExpenseDataSource) {

    suspend fun createExpense(expense: Expense): Long =
        expenseDataSource.createExpense(expense)

    suspend fun deleteExpense(expense: Expense): Int =
        expenseDataSource.deleteExpense(expense)

    suspend fun updateExpense(expense: Expense): Int =
        expenseDataSource.updateExpense(expense)

    suspend fun getAllExpenses(): List<Expense> = expenseDataSource.getAllExpenses()
}