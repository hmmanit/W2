package com.homanad.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.w2.common.BaseDao
import com.homanad.android.w2.data.model.WalletData

@Dao
abstract class WalletDao : BaseDao<WalletData> {

    @Query("SELECT * FROM WalletData")
    abstract suspend fun getAll(): List<WalletData>
}