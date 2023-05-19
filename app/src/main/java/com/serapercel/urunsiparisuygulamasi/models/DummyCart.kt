package com.serapercel.urunsiparisuygulamasi.models

data class DummyCart(
    val id: Long? = null,
    val products: List<CartProduct>? = null,
    val total: Long? = null,
    val discountedTotal: Long? = null,
    val userID: Long? = null,
    val totalProducts: Long? = null,
    val totalQuantity: Long? = null
)

data class CartProduct(
    val id: Long? = null,
    val title: String? = null,
    val price: Long? = null,
    val quantity: Long? = null,
    val total: Long? = null,
    val discountPercentage: Double? = null,
    val discountedPrice: Long? = null
)