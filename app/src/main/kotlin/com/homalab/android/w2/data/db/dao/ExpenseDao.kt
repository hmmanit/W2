package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homalab.android.w2.common.BaseDao
import com.homalab.android.w2.data.entity.Expense

@Dao
abstract class ExpenseDao : BaseDao<Expense> {

    @Query("SELECT * FROM Expense ORDER BY createdTime DESC") //TODO Sort condition
    abstract suspend fun getAllSpending(): List<Expense>
}