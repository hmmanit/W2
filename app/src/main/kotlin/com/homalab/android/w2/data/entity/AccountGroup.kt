package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccountGroup(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val createdTime: Long,
    val updatedTime: Long
)