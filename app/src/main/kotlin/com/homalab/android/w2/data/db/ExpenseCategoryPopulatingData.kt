package com.homalab.android.w2.data.db

import com.homalab.android.w2.data.entity.Category

//Eating out TODO For testing
val eatingOutSubCategories = listOf(
    Category(0, "A", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3),
    Category(0, "B", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3),
    Category(0, "C", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3),
    Category(0, "D", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3),
)

//Food
val foodSubCategories = listOf(
    Category(0, "Lunch", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Dinner", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Eating out", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, eatingOutSubCategories),
    Category(0, "Beverages", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
)

//Social Life
val socialLifeSubCategories = listOf(
    Category(0, "Friend", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Fellowship", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Alumni", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Dues", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//Transportation
val transportationSubCategoties = listOf(
    Category(0, "Bus", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Taxi", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Subway", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Car", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//Culture
val cultureSubCategories = listOf(
    Category(0, "Books", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Movie", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Music", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Apps", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//House hold
val houseHoldSubCategories = listOf(
    Category(0, "Appliances", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Furniture", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Kitchen", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Toiletries", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Chandlery", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//Apparel
val apparelSubCategories = listOf(
    Category(0, "Clothing", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Fashion", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Shoes", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Laundry", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//Health
val healthSubCategories = listOf(
    Category(0, "Health", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Yoga", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Gym", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Hospital", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Medicine", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//Beauty
val beautySubCategories = listOf(
    Category(0, "Cosmetics", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Makeup", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Accessories", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Beauty", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2)
)

//Education
val educationSubCategories = listOf(
    Category(0, "Schooling", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 2),
    Category(0, "Textbooks", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "School supplies", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2),
    Category(0, "Academy", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2)
)

val expenseCategories = listOf(
    Category(0, "Food", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(), 1, foodSubCategories),
    Category(0, "Social Life", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 1, socialLifeSubCategories),
    Category(0, "Self-development", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),1),
    Category(0, "Transportation", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 1, transportationSubCategoties),
    Category(0, "Culture", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(), 1, cultureSubCategories),
    Category(0, "Household", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),1, houseHoldSubCategories),
    Category(0, "Apparel", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),1, apparelSubCategories),
    Category(0, "Beauty", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),1, beautySubCategories),
    Category(0, "Health", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 1, healthSubCategories),
    Category(0, "Education", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),1, educationSubCategories),
    Category(0, "Gift", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),1),
    Category(0, "Other", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),1)
)