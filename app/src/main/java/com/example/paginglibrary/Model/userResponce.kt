package com.example.paginglibrary.Model

data class userResponce(
    val ad: Ad,
    val `data`: List<User>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)