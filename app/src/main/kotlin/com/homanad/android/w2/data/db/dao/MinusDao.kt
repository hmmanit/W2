package com.homanad.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.w2.common.BaseDao
import com.homanad.android.w2.data.model.MinusData

@Dao
abstract class MinusDao : BaseDao<MinusData> {

    @Query("SELECT * FROM MinusData")
    abstract suspend fun getAll(): List<MinusData>
}