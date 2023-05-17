package com.serapercel.uruntanitimuygulamasi.models

data class DummyProducts (
    val products: List<Product>,
    val total: Long,
    val skip: Long,
    val limit: Long
)