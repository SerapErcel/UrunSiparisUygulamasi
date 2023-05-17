package com.serapercel.urunsiparisuygulamasi.services

import com.serapercel.urunsiparisuygulamasi.models.DummyCart
import com.serapercel.urunsiparisuygulamasi.models.RequestCart
import com.serapercel.urunsiparisuygulamasi.models.RequestProduct
import com.serapercel.uruntanitimuygulamasi.models.DummyProducts
import com.serapercel.uruntanitimuygulamasi.models.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @GET("products")
    fun products(): Call<DummyProducts>

    @GET("products/{id}")
    fun singleProduct(@Path("id") id: Int): Call<Product>

    @POST("carts/add")
    fun addCart(@Body cart: RequestCart): Call<RequestCart>

    @GET("carts/1")
    fun getCart(): Call<DummyCart>
}