package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(primaryKeys = ["id", "groupId"], indices = [Index(value = ["id"], unique = true)]) doesn't working
@Entity
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val groupId: Long,
    val name: String,
    val budget: Float,
    val createdTime: Long,
    val updatedTime: Long
)