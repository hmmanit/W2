package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homalab.android.w2.common.BaseDao
import com.homalab.android.w2.data.model.Account

@Dao
abstract class AccountDao : BaseDao<Account> {

    @Query("SELECT * FROM Account")
    abstract suspend fun getAllAccounts(): List<Account>
}