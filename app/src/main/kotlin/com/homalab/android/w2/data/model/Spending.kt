package com.homalab.android.w2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Spending(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String,
    val amount: Float,
    val walletId: Long //optional
)