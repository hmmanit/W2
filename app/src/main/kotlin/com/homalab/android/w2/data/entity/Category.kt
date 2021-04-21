package com.homalab.android.w2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "",
    val type: Int = Type.EXPENSE.ordinal,
    val createdTime: Long = System.currentTimeMillis(),
    val updatedTime: Long = System.currentTimeMillis(),
    val deepVal: Int,
    val subCategories: List<Category> = listOf()
) {
    enum class Type {
        EXPENSE, INCOME
    }
}