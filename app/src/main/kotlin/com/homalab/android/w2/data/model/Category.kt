package com.homalab.android.w2.data.model

import androidx.room.Entity

@Entity
data class Category(
    val id: Long = 0,
    val name: String = "",
    val createdTime: Long = System.currentTimeMillis(),
    val updatedTime: Long = System.currentTimeMillis(),
    val subCategories: List<Category> = listOf()
)