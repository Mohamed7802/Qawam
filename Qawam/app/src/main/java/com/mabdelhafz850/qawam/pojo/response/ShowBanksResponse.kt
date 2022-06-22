package com.mabdelhafz850.deliverydemoapp.pojo.response

data class ShowBanksResponse(
    var data: List<Bank>,
    var error: Int,
    var message: String
)

data class Bank(
    var id: Int,
    var name: String
)