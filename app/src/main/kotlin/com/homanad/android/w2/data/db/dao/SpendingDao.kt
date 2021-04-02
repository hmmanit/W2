package com.homanad.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.w2.common.BaseDao
import com.homanad.android.w2.data.model.Spending

@Dao
abstract class SpendingDao : BaseDao<Spending> {

    @Query("SELECT * FROM Spending")
    abstract suspend fun getAllSpending(): List<Spending>
}