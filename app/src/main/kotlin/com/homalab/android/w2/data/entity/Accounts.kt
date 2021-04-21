package com.homalab.android.w2.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class Accounts(
    @Embedded
    val accountGroup: AccountGroup,
    @Relation(
        parentColumn = "id",
        entityColumn = "groupId"
    )
    val accounts: List<Account> = ArrayList()
)