package com.homalab.android.w2.data.repository.category.datasource

import com.homalab.android.w2.data.entity.Category

interface CategoryDataSource {
    suspend fun createCategory(category: Category): Long

    suspend fun deleteCategory(category: Category): Int

    suspend fun updateCategory(category: Category): Int

    suspend fun getAllCategories(): List<Category>
}