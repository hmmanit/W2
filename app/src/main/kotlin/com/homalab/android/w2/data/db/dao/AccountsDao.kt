package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.homalab.android.w2.data.entity.Accounts

@Dao
interface AccountsDao {

    @Transaction
    @Query("SELECT * FROM AccountGroup")
    suspend fun getAccounts(): List<Accounts>
}