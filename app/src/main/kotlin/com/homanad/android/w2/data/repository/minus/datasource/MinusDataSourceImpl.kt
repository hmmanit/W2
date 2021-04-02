package com.homanad.android.w2.data.repository.minus.datasource

import com.homanad.android.w2.data.db.WDatabase
import com.homanad.android.w2.data.model.MinusData

class MinusDataSourceImpl(wDatabase: WDatabase) : MinusDataSource {

    private val minusDao = wDatabase.minusDao

    override suspend fun createMinus(minusEntity: MinusData): Long {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMinus(minusEntity: MinusData): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateMinus(minusEntity: MinusData): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<MinusData> {
        TODO("Not yet implemented")
    }
}