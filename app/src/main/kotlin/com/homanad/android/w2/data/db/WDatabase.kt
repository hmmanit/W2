package com.homanad.android.w2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.homanad.android.w2.data.db.dao.AccountDao
import com.homanad.android.w2.data.db.dao.SpendingDao
import com.homanad.android.w2.data.model.Spending
import com.homanad.android.w2.data.model.Account

@Database(entities = [Spending::class, Account::class], version = 1)
abstract class WDatabase : RoomDatabase() {

    abstract val spendingDao: SpendingDao
    abstract val accountDao: AccountDao

    companion object {

        @Volatile
        private var INSTANCE: WDatabase? = null
        fun getInstance(context: Context): WDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        WDatabase::class.java,
                        WDatabase::class.java.simpleName
                    ).build()
                }
                return instance
            }
        }
    }
}