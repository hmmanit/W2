package com.homanad.android.w2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val budget: Float
)