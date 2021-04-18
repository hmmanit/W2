package com.homalab.android.w2.data.repository.spending

import com.homalab.android.w2.data.model.Spending
import com.homalab.android.w2.data.repository.spending.datasource.SpendingDataSource
import javax.inject.Inject

class SpendingRepository @Inject constructor(private val spendingDataSource: SpendingDataSource) {

    suspend fun createSpending(spending: Spending): Long =
        spendingDataSource.createSpending(spending)

    suspend fun deleteSpending(spending: Spending): Int =
        spendingDataSource.deleteSpending(spending)

    suspend fun updateSpending(spending: Spending): Int =
        spendingDataSource.updateSpending(spending)

    suspend fun getAll(): List<Spending> = spendingDataSource.getAllSpending()
}