package za.co.howtogeek.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
    JSON data from https://themealdb.com/api.php:
      "idCategory": "1",
      "strCategory": "Beef",
      "strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
      "strCategoryDescription"
 */

// data class on the different categories:
@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String): Parcelable


data class CategoriesResponse(val categories: List<Category>)
