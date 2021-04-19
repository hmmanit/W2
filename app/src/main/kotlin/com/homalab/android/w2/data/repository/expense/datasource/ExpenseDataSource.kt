package com.homalab.android.w2.data.repository.expense.datasource

import com.homalab.android.w2.data.model.Expense

interface ExpenseDataSource {
    suspend fun createSpending(expense: Expense): Long

    suspend fun deleteSpending(expense: Expense): Int

    suspend fun updateSpending(expense: Expense): Int

    suspend fun getAllSpending(): List<Expense>
}