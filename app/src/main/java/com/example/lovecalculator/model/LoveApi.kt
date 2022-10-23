package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculate(
        @Query("fname") firstName: String,
        @Query("sname") secondName:String,
        @Header("X-RapidAPI-Key") key:String="57d409a12emsh5e2d0f94859c24fp17fd82jsn93af7bc5edf2",
        @Header("X-RapidAPI-Host") host:String="love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}