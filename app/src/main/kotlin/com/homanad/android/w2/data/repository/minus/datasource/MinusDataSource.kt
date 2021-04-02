package com.homanad.android.w2.data.repository.minus.datasource

import com.homanad.android.w2.data.model.MinusData


interface MinusDataSource {
    suspend fun createMinus(minusEntity: MinusData): Long

    suspend fun deleteMinus(minusEntity: MinusData): Int

    suspend fun updateMinus(minusEntity: MinusData): Int

    suspend fun getAll(): List<MinusData>
}