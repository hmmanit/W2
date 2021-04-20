package com.homalab.android.w2.data.db

import com.homalab.android.w2.data.model.Category

//Food
val foodSubCategories = listOf(
    Category(0, "Lunch", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Dinner", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Eating out", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Beverages", System.currentTimeMillis(), System.currentTimeMillis()),
)

//Social Life
val socialLifeSubCategories = listOf(
    Category(0, "Friend", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Fellowship", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Alumni", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Dues", System.currentTimeMillis(), System.currentTimeMillis())
)

//Transportation
val transportationSubCategoties = listOf(
    Category(0, "Bus", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Taxi", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Subway", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Car", System.currentTimeMillis(), System.currentTimeMillis())
)

//Culture
val cultureSubCategories = listOf(
    Category(0, "Books", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Movie", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Music", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Apps", System.currentTimeMillis(), System.currentTimeMillis())
)

//House hold
val houseHoldSubCategories = listOf(
    Category(0, "Appliances", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Furniture", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Kitchen", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Toiletries", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Chandlery", System.currentTimeMillis(), System.currentTimeMillis())
)

//Apparel
val apparelSubCategories = listOf(
    Category(0, "Clothing", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Fashion", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Shoes", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Laundry", System.currentTimeMillis(), System.currentTimeMillis())
)

//Health
val healthSubCategories = listOf(
    Category(0, "Health", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Yoga", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Gym", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Hospital", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Medicine", System.currentTimeMillis(), System.currentTimeMillis())
)

//Beauty
val beautySubCategories = listOf(
    Category(0, "Cosmetics", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Makeup", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Accessories", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Beauty", System.currentTimeMillis(), System.currentTimeMillis())
)

//Education
val educationSubCategories = listOf(
    Category(0, "Schooling", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Textbooks", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "School supplies", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Academy", System.currentTimeMillis(), System.currentTimeMillis())
)

val categories = listOf(
    Category(0, "Food", System.currentTimeMillis(), System.currentTimeMillis(), foodSubCategories),
    Category(0, "Social Life", System.currentTimeMillis(), System.currentTimeMillis(), socialLifeSubCategories),
    Category(0, "Self-development", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Transportation", System.currentTimeMillis(), System.currentTimeMillis(), transportationSubCategoties),
    Category(0, "Culture", System.currentTimeMillis(), System.currentTimeMillis(), cultureSubCategories),
    Category(0, "Household", System.currentTimeMillis(), System.currentTimeMillis(), houseHoldSubCategories),
    Category(0, "Apparel", System.currentTimeMillis(), System.currentTimeMillis(), apparelSubCategories),
    Category(0, "Beauty", System.currentTimeMillis(), System.currentTimeMillis(), beautySubCategories),
    Category(0, "Health", System.currentTimeMillis(), System.currentTimeMillis(), healthSubCategories),
    Category(0, "Education", System.currentTimeMillis(), System.currentTimeMillis(), educationSubCategories),
    Category(0, "Gift", System.currentTimeMillis(), System.currentTimeMillis()),
    Category(0, "Other", System.currentTimeMillis(), System.currentTimeMillis())
)