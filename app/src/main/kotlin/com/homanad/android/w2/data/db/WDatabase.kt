package com.homanad.android.w2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.homanad.android.w2.data.db.dao.WalletDao
import com.homanad.android.w2.data.db.dao.MinusDao
import com.homanad.android.w2.data.model.MinusData
import com.homanad.android.w2.data.model.WalletData

@Database(entities = [MinusData::class, WalletData::class], version = 1)
abstract class WDatabase : RoomDatabase() {

    abstract val minusDao: MinusDao
    abstract val walletDao: WalletDao

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