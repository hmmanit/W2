package com.homanad.android.w2.data.repository.spending

import com.homanad.android.w2.data.model.Spending

interface SpendingRepository {

    suspend fun createMinus(spending: Spending): Long

    suspend fun deleteMinus(spending: Spending): Int

    suspend fun updateMinus(spending: Spending): Int

    suspend fun getAll(): List<Spending>
}