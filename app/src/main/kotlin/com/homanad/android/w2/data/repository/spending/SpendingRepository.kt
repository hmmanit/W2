package com.homanad.android.w2.data.repository.spending

import com.homanad.android.w2.data.model.Spending
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSource
import javax.inject.Inject

class SpendingRepository @Inject constructor(private val spendingDataSource: SpendingDataSource) {

    suspend fun createMinus(spending: Spending): Long = spendingDataSource.createMinus(spending)

    suspend fun deleteMinus(spending: Spending): Int = spendingDataSource.deleteMinus(spending)

    suspend fun updateMinus(spending: Spending): Int = spendingDataSource.updateMinus(spending)

    suspend fun getAll(): List<Spending> = spendingDataSource.getAll()
}