package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homalab.android.w2.common.BaseDao
import com.homalab.android.w2.data.entity.AccountGroup

@Dao
abstract class AccountGroupDao : BaseDao<AccountGroup> {

    @Query("SELECT * FROM AccountGroup")
    abstract suspend fun getAccountGroups(): List<AccountGroup>
}