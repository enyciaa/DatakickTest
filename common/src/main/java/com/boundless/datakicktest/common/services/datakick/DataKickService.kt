package com.boundless.datakicktest.common.services.datakick

import com.boundless.datakicktest.common.entities.Product
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response

class DataKickService(
    private val dataKickApi: DataKickApi
) {

  fun fetchProducts(): List<Product> {
    return handleCall(dataKickApi.fetchItems())!!
            .mapToProducts()
  }

  private fun <T> handleCall(call: Call<T>): T? {
    val response = call.execute()
    if (response.isSuccessful) {
      return response.body()
    } else {
      handleError(call.request(), response)
    }
  }

  private fun <T> handleError(
          request: Request,
          response: Response<T>
  ): Nothing {
    // Handle HTTP or API error codes here using the request and response
    throw DataKickException()
  }

}
