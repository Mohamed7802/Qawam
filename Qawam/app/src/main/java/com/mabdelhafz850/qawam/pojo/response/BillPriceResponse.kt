package com.mabdelhafz850.deliverydemoapp.pojo.response

data class BillPriceResponse(
        val data: Data,
        val error: Int,
        val message: String
) {
    data class Data(
            val price: Int,
            val taxs: Int,
            val total_price: Int
    )
}