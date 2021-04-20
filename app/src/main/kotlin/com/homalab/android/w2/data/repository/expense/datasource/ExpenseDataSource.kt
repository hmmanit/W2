package com.homalab.android.w2.data.repository.expense.datasource

import com.homalab.android.w2.data.entity.Expense

interface ExpenseDataSource {
    suspend fun createExpense(expense: Expense): Long

    suspend fun deleteExpense(expense: Expense): Int

    suspend fun updateExpense(expense: Expense): Int

    suspend fun getAllExpenses(): List<Expense>
}