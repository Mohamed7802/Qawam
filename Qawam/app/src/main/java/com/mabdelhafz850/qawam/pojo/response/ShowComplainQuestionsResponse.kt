package com.mabdelhafz850.deliverydemoapp.pojo.response

data class ShowComplainQuestionsResponse(
    var data: List<Question>,
    var error: Int,
    var message: String
)

data class Question(
    var id: Int,
    var name: String
)