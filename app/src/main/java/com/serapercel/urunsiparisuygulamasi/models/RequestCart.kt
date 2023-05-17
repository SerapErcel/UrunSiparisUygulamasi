package com.serapercel.urunsiparisuygulamasi.models

data class RequestCart(
    val userId: Int,
    val products: List<RequestProduct>
)