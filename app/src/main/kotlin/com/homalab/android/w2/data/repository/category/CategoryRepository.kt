package com.homalab.android.w2.data.repository.category

import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.repository.category.datasource.CategoryDataSource
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryDataSource: CategoryDataSource) {

    suspend fun createSpending(category: Category): Long =
        categoryDataSource.createCategory(category)

    suspend fun deleteSpending(category: Category): Int =
        categoryDataSource.deleteCategory(category)

    suspend fun updateSpending(category: Category): Int =
        categoryDataSource.updateCategory(category)

    suspend fun getAll(): List<Category> = categoryDataSource.getAllCategories()
}