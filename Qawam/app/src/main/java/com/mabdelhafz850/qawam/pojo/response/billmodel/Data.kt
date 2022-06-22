package com.mabdelhafz850.deliverydemoapp.pojo.response.billmodel

data class Data(
    val agent_name: String,
    val delivery_price: Int,
    val id: Int,
    val order_price: Int,
    val tax: String,
    val total_price: Int,
    val user_name: String
)