package za.co.howtogeek.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Base URL: www.themealdb.com/api/json/v1/1/
 */

//private val baseUrl = "https://www.themealdb.com/api/json/v1/1/"

// https://www.themealdb.com/api/json/v1/1/categories.php
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/") //(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse
}