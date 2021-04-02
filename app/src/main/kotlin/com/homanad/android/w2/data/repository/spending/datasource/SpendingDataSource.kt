package com.homanad.android.w2.data.repository.spending.datasource

import com.homanad.android.w2.data.model.Spending


interface SpendingDataSource {
    suspend fun createMinus(minusEntity: Spending): Long

    suspend fun deleteMinus(minusEntity: Spending): Int

    suspend fun updateMinus(minusEntity: Spending): Int

    suspend fun getAll(): List<Spending>
}