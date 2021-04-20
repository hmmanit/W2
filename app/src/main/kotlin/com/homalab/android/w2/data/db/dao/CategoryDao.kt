package com.homalab.android.w2.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homalab.android.w2.common.BaseDao
import com.homalab.android.w2.data.entity.Category

@Dao
abstract class CategoryDao : BaseDao<Category> {

    @Query("SELECT * FROM Category")
    abstract suspend fun getAllCategories(): List<Category>
}