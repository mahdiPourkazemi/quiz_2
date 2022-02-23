package com.pourkazemi.mahdi.myquiz.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface FlickerService {
    @GET("services/rest")
    fun getFlicker(
        @Query("api_key") api_key:  String,
        @Query("method") method: String,
        @Query("user_id")user_id: String,
        @Query("extras")extras:String,
        @Query("format")format: String,
        @Query("nojsoncallback")nojsoncallback: String,
        @Query("per_page")per_page:  String,
        @Query("page")page:  String
    ):Call<FlickerResponse>


}