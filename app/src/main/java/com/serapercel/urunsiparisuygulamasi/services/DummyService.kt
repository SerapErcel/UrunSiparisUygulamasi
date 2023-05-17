package com.serapercel.urunsiparisuygulamasi.services

import com.serapercel.uruntanitimuygulamasi.models.DummyProducts
import com.serapercel.uruntanitimuygulamasi.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyService {

    @GET("products")
    fun products() : Call<DummyProducts>

    @GET("products/{id}")
    fun singleProduct( @Path("id") id: Int ) : Call<Product>


}