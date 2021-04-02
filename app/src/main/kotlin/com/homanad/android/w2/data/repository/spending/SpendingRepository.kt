package com.homanad.android.w2.data.repository.spending

import com.homanad.android.w2.data.model.Spending
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSource
import javax.inject.Inject

class SpendingRepository @Inject constructor(private val spendingDataSource: SpendingDataSource) {

    suspend fun createMinus(spending: Spending): Long = spendingDataSource.createSpending(spending)

    suspend fun deleteMinus(spending: Spending): Int = spendingDataSource.deleteSpending(spending)

    suspend fun updateMinus(spending: Spending): Int = spendingDataSource.updateSpending(spending)

    suspend fun getAll(): List<Spending> = spendingDataSource.getAllSpending()
}