package com.example.androidauthapp

data class User(
    val id: Int,
    val username: String,
    val passwordHash: String // Trong ứng dụng thực tế, nên lưu trữ hash của mật khẩu
)
