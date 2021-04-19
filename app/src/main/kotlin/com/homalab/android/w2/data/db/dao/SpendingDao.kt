package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homalab.android.w2.common.BaseDao
import com.homalab.android.w2.data.model.Spending

@Dao
abstract class SpendingDao : BaseDao<Spending> {

    @Query("SELECT * FROM Spending ORDER BY createdTime DESC") //TODO Sort condition
    abstract suspend fun getAllSpending(): List<Spending>
}