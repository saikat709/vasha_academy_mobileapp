package com.vashaacademy.backend

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api{
    companion object {
        private var api: Api? = null
        fun getInstance(): Api{
            if(api == null){
                api = Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api::class.java)
            }
            return api!!
        }
    }

    @GET("all")
    fun getCourses(): List<Course>{

        return listOf(Course())
    }
}