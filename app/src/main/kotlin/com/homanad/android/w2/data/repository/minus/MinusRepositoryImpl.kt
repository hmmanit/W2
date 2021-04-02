package com.homanad.android.w2.data.repository.minus

import com.homanad.android.w2.data.model.MinusData
import com.homanad.android.w2.data.repository.minus.datasource.MinusDataSource

class MinusRepositoryImpl(private val minusDataSource: MinusDataSource) : MinusRepository {

    override suspend fun createMinus(minusData: MinusData): Long =
        minusDataSource.createMinus(minusData)

    override suspend fun deleteMinus(minusData: MinusData): Int =
        minusDataSource.deleteMinus(minusData)

    override suspend fun updateMinus(minusData: MinusData): Int =
        minusDataSource.updateMinus(minusData)

    override suspend fun getAll(): List<MinusData> = minusDataSource.getAll()
}