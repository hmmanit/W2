package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccountGroup(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val description: String? = "", //TODO ??
    val createdTime: Long = 0,
    val updatedTime: Long = 0
)