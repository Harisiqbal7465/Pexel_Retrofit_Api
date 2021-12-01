package com.example.pexelretrofitapi.model.videomodel

data class VideoPexel(
    val page: Int,
    val per_page: Int,
    val total_results: Int,
    val url: String,
    val videos: List<Video>
)