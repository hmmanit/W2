package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(primaryKeys = ["id", "groupId"], indices = [Index(value = ["id"], unique = true)]) doesn't working
@Entity
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val groupId: Long = 0,
    val name: String = "",
    val budget: Float = 0f,
    val createdTime: Long = 0,
    val updatedTime: Long = 0
)