package com.homanad.android.w2.data.repository.spending.datasource

import com.homanad.android.w2.data.model.Spending


interface SpendingDataSource {
    suspend fun createSpending(spending: Spending): Long

    suspend fun deleteSpending(spending: Spending): Int

    suspend fun updateSpending(spending: Spending): Int

    suspend fun getAllSpending(): List<Spending>
}