package com.homalab.android.w2.common

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

interface RxBaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: T): Single<Long>

    @Insert
    fun insert(vararg obj: T)

    @Insert
    fun insert(objs: List<T>): Completable

    @Delete
    fun delete(vararg obj: T): Single<Int>

    @Update
    fun update(vararg obj: T): Single<Int>
}