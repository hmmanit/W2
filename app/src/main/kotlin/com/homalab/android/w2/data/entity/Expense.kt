package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val amount: Float = 0f,
    val walletId: Long = 0, //optional
    val createdTime: Long = 0,
    val updatedTime: Long = 0
)