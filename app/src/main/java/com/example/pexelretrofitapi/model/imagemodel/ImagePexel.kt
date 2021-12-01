package com.example.pexelretrofitapi.model.imagemodel

data class ImagePexel(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>
)