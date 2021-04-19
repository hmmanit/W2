package com.homalab.android.w2.data.repository.category.datasource

import com.homalab.android.w2.data.db.dao.CategoryDao
import com.homalab.android.w2.data.model.Category
import javax.inject.Inject

class CategoryDataSourceImpl
@Inject constructor(private val categoryDao: CategoryDao) : CategoryDataSource {

    override suspend fun createCategory(category: Category): Long {
        return categoryDao.insert(category)
    }

    override suspend fun deleteCategory(category: Category): Int {
        return categoryDao.delete(category)
    }

    override suspend fun updateCategory(category: Category): Int {
        return categoryDao.update(category)
    }

    override suspend fun getAllCategories(): List<Category> {
        return categoryDao.getAllCategories()
    }
}