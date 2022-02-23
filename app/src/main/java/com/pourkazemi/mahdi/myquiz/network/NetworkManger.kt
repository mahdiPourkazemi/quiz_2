package com.pourkazemi.mahdi.myquiz.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManger {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.flickr.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val networkMangerFlickerService = retrofit.create(FlickerService::class.java)
}