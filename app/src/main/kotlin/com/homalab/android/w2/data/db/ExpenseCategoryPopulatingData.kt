package com.homalab.android.w2.data.db

import com.homalab.android.w2.data.entity.Category

const val ID_ROOT = -1L
const val ID_FOOD = 1L
const val ID_SOCIAL_LIFE= 2L
const val ID_SELF_DEVELOPMENT = 3L
const val ID_TRANSPORTATION = 4L
const val ID_CULTURE =5L
const val ID_HOUSEHOLD = 6L
const val ID_APPAREL = 7L
const val ID_BEAUTY = 8L
const val ID_HEALTH =9L
const val ID_EDUCATION = 10L
const val ID_GIFT = 11L
const val ID_OTHER = 12L

////Eating out TODO For testing
val eatingOutSubCategories = listOf(
    Category(0, "A", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3, 15),
    Category(0, "B", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3, 15),
    Category(0, "C", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3, 15),
    Category(0, "D", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),3, 15),
)

//Food
val foodSubCategories = listOf(
    Category(0, "Lunch", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_FOOD),
    Category(0, "Dinner", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_FOOD),
    Category(0, "Eating out", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_FOOD),
    Category(0, "Beverages", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_FOOD),
)

//Social Life
val socialLifeSubCategories = listOf(
    Category(0, "Friend", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_SOCIAL_LIFE),
    Category(0, "Fellowship", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_SOCIAL_LIFE),
    Category(0, "Alumni", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_SOCIAL_LIFE),
    Category(0, "Dues", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_SOCIAL_LIFE)
)

//Transportation
val transportationSubCategoties = listOf(
    Category(0, "Bus", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_TRANSPORTATION),
    Category(0, "Taxi", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_TRANSPORTATION),
    Category(0, "Subway", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_TRANSPORTATION),
    Category(0, "Car", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_TRANSPORTATION)
)

//Culture
val cultureSubCategories = listOf(
    Category(0, "Books", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_CULTURE),
    Category(0, "Movie", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_CULTURE),
    Category(0, "Music", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_CULTURE),
    Category(0, "Apps", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_CULTURE)
)

//House hold
val houseHoldSubCategories = listOf(
    Category(0, "Appliances", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HOUSEHOLD),
    Category(0, "Furniture", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HOUSEHOLD),
    Category(0, "Kitchen", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HOUSEHOLD),
    Category(0, "Toiletries", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HOUSEHOLD),
    Category(0, "Chandlery", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HOUSEHOLD)
)

//Apparel
val apparelSubCategories = listOf(
    Category(0, "Clothing", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_APPAREL),
    Category(0, "Fashion", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_APPAREL),
    Category(0, "Shoes", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_APPAREL),
    Category(0, "Laundry", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_APPAREL)
)

//Health
val healthSubCategories = listOf(
    Category(0, "Health", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HEALTH),
    Category(0, "Yoga", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HEALTH),
    Category(0, "Gym", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HEALTH),
    Category(0, "Hospital", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HEALTH),
    Category(0, "Medicine", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_HEALTH)
)

//Beauty
val beautySubCategories = listOf(
    Category(0, "Cosmetics", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_BEAUTY),
    Category(0, "Makeup", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_BEAUTY),
    Category(0, "Accessories", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_BEAUTY),
    Category(0, "Beauty", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis(),2, ID_BEAUTY)
)

//Education
val educationSubCategories = listOf(
    Category(0, "Schooling", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(), 2, ID_EDUCATION),
    Category(0, "Textbooks", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_EDUCATION),
    Category(0, "School supplies", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_EDUCATION),
    Category(0, "Academy", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis(),2, ID_EDUCATION)
)

val expenseParentCategories = listOf(
    Category(ID_FOOD, "Food", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_SOCIAL_LIFE, "Social Life", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_SELF_DEVELOPMENT, "Self-development", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_TRANSPORTATION, "Transportation", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_CULTURE, "Culture", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_HOUSEHOLD, "Household", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_APPAREL, "Apparel", Category.Type.EXPENSE.ordinal, System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_BEAUTY, "Beauty", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_HEALTH, "Health", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_EDUCATION, "Education", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_GIFT, "Gift", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis()),
    Category(ID_OTHER, "Other", Category.Type.EXPENSE.ordinal,System.currentTimeMillis(), System.currentTimeMillis())
)

val expenseCategories = mutableListOf<Category>().apply {
    addAll(expenseParentCategories)
    addAll(foodSubCategories)
    addAll(socialLifeSubCategories)
    addAll(transportationSubCategoties)
    addAll(cultureSubCategories)
    addAll(houseHoldSubCategories)
    addAll(apparelSubCategories)
    addAll(healthSubCategories)
    addAll(beautySubCategories)
    addAll(educationSubCategories)
    addAll(eatingOutSubCategories)
}

