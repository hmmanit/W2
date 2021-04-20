package com.homalab.android.w2.data.repository.category

import com.homalab.android.w2.data.entity.Category
import com.homalab.android.w2.data.repository.category.datasource.CategoryDataSource
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryDataSource: CategoryDataSource) {

    suspend fun createCategory(category: Category): Long =
        categoryDataSource.createCategory(category)

    suspend fun deleteCategory(category: Category): Int =
        categoryDataSource.deleteCategory(category)

    suspend fun updateCategory(category: Category): Int =
        categoryDataSource.updateCategory(category)

    suspend fun getAllCategories(type: Int): List<Category> = categoryDataSource.getAllCategories(type)
}