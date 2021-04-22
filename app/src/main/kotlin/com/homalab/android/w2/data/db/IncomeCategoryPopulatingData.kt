package com.homalab.android.w2.data.db

import com.homalab.android.w2.data.entity.Category

//Allowance
val allowanceCategories = listOf<Category>(
//    Category(0, "Lunch", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Dinner", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Eating out", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Beverages", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
)

//Salary
val salarySubCategories = listOf<Category>(
//    Category(0, "Friend", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Fellowship", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Alumni", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Dues", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis())
)

//Petty cash
val pettyCashSubCategoties = listOf<Category>(
//    Category(0, "Bus", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Taxi", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Subway", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Car", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis())
)

//Bonus
val bonusSubCategories = listOf<Category>(
//    Category(0, "Books", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Movie", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Music", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Apps", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis())
)

//Other
val otherSubCategories = listOf<Category>(
//    Category(0, "Appliances", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Furniture", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Kitchen", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Toiletries", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
//    Category(0, "Chandlery", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis())
)

val incomeCategories = listOf(
    Category(0, "Allowance", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis(), 1),
    Category(0, "Salary", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 1),
    Category(0, "Petty cash", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 1),
    Category(0, "Bonus", Category.Type.INCOME.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 1),
    Category(0, "Other", Category.Type.INCOME.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),1)
)