package com.boundless.datakicktest.common.services.datakick.entities

import com.squareup.moshi.Json

data class RawDataKickResponse(
    @Json(name = "gtin14") val gtin14: String? = null,
    @Json(name = "images") val images: List<String>? = null,
    @Json(name = "pages") val pages: Int? = null,
    @Json(name = "author") val author: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "format") val format: String? = null,
    @Json(name = "publisher") val publisher: String? = null,
    @Json(name = "fiber") val fiber: Int? = null,
    @Json(name = "sugars") val sugars: Int? = null,
    @Json(name = "fat_calories") val fatCalories: Int? = null,
    @Json(name = "brand_name") val brandName: String? = null,
    @Json(name = "calories") val calories: Int? = null,
    @Json(name = "servings_per_container") val servingsPerContainer: String? = null,
    @Json(name = "saturated_fat") val saturatedFat: String? = null,
    @Json(name = "carbohydrate") val carbohydrate: Int? = null,
    @Json(name = "sodium") val sodium: Int? = null,
    @Json(name = "size") val size: String? = null,
    @Json(name = "serving_size") val servingSize: String? = null,
    @Json(name = "protein") val protein: Int? = null,
    @Json(name = "fat") val fat: String? = null,
    @Json(name = "trans_fat") val transFat: String? = null,
    @Json(name = "cholesterol") val cholesterol: Int? = null
)
