package com.homanad.android.w2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Spending(
    @PrimaryKey(autoGenerate = true)
    private val id: Long,
    private val title: String,
    private val description: String,
    private val amount: Float,
    private val walletId: Long //optional
)