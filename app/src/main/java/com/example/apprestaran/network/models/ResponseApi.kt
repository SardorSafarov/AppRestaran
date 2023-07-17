package com.example.apprestaran.network.models

class ResponseApi(
    val status: Boolean,
    val data: Any,
    val message: String,
    val code: Int
)