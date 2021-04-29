package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Income(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val note: String = "",
    val description: String = "",
    val amount: Float = 0f,
    val accountId: Long = 0, //optional
    val categoryId: Long = 0,
    val createdTime: Long = 0,
    val updatedTime: Long = 0
)