package com.example.myapplication.network

import com.example.myapplication.model.SchoolDetails
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchoolDetails():List<SchoolDetails>

    companion object{
        var apiService:ApiService ?= null

        fun getInstance(baseUrl:String):ApiService {
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create()
            }
            return apiService!!
        }
    }
}