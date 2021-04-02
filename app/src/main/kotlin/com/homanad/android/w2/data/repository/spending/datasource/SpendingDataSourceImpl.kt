package com.homanad.android.w2.data.repository.spending.datasource

import com.homanad.android.w2.data.db.dao.SpendingDao
import com.homanad.android.w2.data.model.Spending
import javax.inject.Inject

class SpendingDataSourceImpl @Inject constructor(private val spendingDao: SpendingDao) :
    SpendingDataSource {

    override suspend fun createSpending(spending: Spending): Long {
        return spendingDao.insert(spending)
    }

    override suspend fun deleteSpending(spending: Spending): Int {
        return spendingDao.delete(spending)
    }

    override suspend fun updateSpending(spending: Spending): Int {
        return spendingDao.update(spending)
    }

    override suspend fun getAllSpending(): List<Spending> {
        return spendingDao.getAllSpending()
    }
}