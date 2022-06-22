package com.mabdelhafz850.deliverydemoapp.pojo.response.billmodel

data class BillModel(
    val `data`: List<Data>,
    val error: Int,
    val message: String
)