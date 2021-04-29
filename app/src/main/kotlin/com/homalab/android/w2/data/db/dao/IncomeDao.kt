package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homalab.android.w2.common.BaseDao
import com.homalab.android.w2.data.entity.Income

@Dao
abstract class IncomeDao : BaseDao<Income> {
    @Query("SELECT * FROM Income ORDER BY createdTime DESC") //TODO Sort condition
    abstract suspend fun getAllIncomes(): List<Income>
}