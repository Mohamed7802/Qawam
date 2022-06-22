package com.mabdelhafz850.deliverydemoapp.pojo.response

data class BillResponse(
        val data: Data,
        val error: Int,
        val message: String
) {
    data class Data(
            val id: Int,
            val user_name:String,
            val agent_name:String,
            val order_price: Int,
            val delivery_price: Int,
            val tax: Int,
            val total_price: Int
    )
}