package com.homalab.android.w2.data.db.converter

import androidx.room.TypeConverter
import com.homalab.android.w2.data.entity.Category
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object CategoryConverter {

    @TypeConverter
    @JvmStatic
    fun convertCategoriesString(categories: List<Category>): String {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, Category::class.java)
        val adapter: JsonAdapter<List<Category>> = moshi.adapter(listType)
        return adapter.toJson(categories)
    }

    @TypeConverter
    @JvmStatic
    fun convertStringToCategories(string: String): List<Category> {
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, Category::class.java)
        val adapter: JsonAdapter<List<Category>> = moshi.adapter(listType)
        return adapter.fromJson(string) ?: listOf()
    }
}