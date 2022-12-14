package com.example.lovecalculator

import android.app.Application
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.RetrofitService

class App : Application() {

    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().api
    }
}