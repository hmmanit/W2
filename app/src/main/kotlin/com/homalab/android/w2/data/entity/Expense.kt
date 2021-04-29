package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val note: String = "",
    val description: String = "",
    val amount: Float = 0f,
    val accountId: Long = 0, //optional
    val createdTime: Long = 0,
    val updatedTime: Long = 0
)