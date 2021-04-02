package com.homanad.android.w2.data.repository.minus

import com.homanad.android.w2.data.model.MinusData

interface MinusRepository {

    suspend fun createMinus(minusData: MinusData): Long

    suspend fun deleteMinus(minusData: MinusData): Int

    suspend fun updateMinus(minusData: MinusData): Int

    suspend fun getAll(): List<MinusData>
}