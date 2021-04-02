package com.homanad.android.w2.data.repository.spending.datasource

import com.homanad.android.w2.data.db.WDatabase
import com.homanad.android.w2.data.model.Spending

class SpendingDataSourceImpl(wDatabase: WDatabase) : SpendingDataSource {

    private val minusDao = wDatabase.spendingDao

    override suspend fun createMinus(minusEntity: Spending): Long {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMinus(minusEntity: Spending): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateMinus(minusEntity: Spending): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Spending> {
        TODO("Not yet implemented")
    }
}