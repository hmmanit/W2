package com.homanad.android.w2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey(autoGenerate = true)
    private val id: Long,
    private val name: String,
    private val budget: Float
)