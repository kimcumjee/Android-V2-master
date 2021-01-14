package com.e.daedo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance: Retrofit?= null
    private var API: Service?= null
    private val baseUrl: String= "https://coatcode.herokuapp.com"

    fun getInstance(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

    fun getService() : Service?{
        if(API == null){
            API = instance?.create(Service::class.java)
        }
        return API
    }
}