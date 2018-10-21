package com.boundless.datakicktest.common.services.datakick.entities

data class RawDataKickResponse(
        val gtin14: String? = null,
        val images: List<String>? = null,
        val pages: Int? = null,
        val author: String? = null,
        val name: String? = null,
        val format: String? = null,
        val publisher: String? = null,
        val fiber: Int? = null,
        val sugars: Int? = null,
        val fat_calories: Int? = null,
        val brand_name: String? = null,
        val calories: Int? = null,
        val servings_per_container: String? = null,
        val saturatedFat: String? = null,
        val carbohydrate: Int? = null,
        val sodium: Int? = null,
        val size: String? = null,
        val serving_size: String? = null,
        val protein: Int? = null,
        val fat: String? = null,
        val trans_fat: String? = null,
        val cholesterol: Int? = null
)
