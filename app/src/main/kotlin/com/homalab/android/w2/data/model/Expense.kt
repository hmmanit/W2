package com.homalab.android.w2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String,
    val amount: Float,
    val walletId: Long, //optional
    val createdTime: Long,
    val updatedTime: Long
)