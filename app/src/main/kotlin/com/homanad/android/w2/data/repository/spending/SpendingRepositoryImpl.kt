package com.homanad.android.w2.data.repository.spending

import com.homanad.android.w2.data.model.Spending
import com.homanad.android.w2.data.repository.spending.datasource.SpendingDataSource

class SpendingRepositoryImpl(private val spendingDataSource: SpendingDataSource) : SpendingRepository {

    override suspend fun createMinus(spending: Spending): Long =
        spendingDataSource.createMinus(spending)

    override suspend fun deleteMinus(spending: Spending): Int =
        spendingDataSource.deleteMinus(spending)

    override suspend fun updateMinus(spending: Spending): Int =
        spendingDataSource.updateMinus(spending)

    override suspend fun getAll(): List<Spending> = spendingDataSource.getAll()
}