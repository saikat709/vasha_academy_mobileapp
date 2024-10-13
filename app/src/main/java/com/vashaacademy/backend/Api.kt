package com.vashaacademy.backend

import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface Api{
    companion object {
        private val TOKEN = "Token f21555a3eb979465f119ea47dd2b06c9c32e767f"

        private var api: Api? = null
        fun getInstance(): Api{
            if(api == null){
                api = Retrofit.Builder()
                    .baseUrl("http://192.168.0.109:8000/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(ResultCallAdapterFactory.create())
                    .build()
                    .create(Api::class.java)
            }
            return api!!
        }
    }

    @GET("course/")
    suspend fun getCourses(
        @Header("Authorization") token: String = TOKEN
    ): Result<List<Course>>

    @GET("course/exam/")
    suspend fun getExams(
        @Header("Authorization") token: String = TOKEN,
        @Path("id") courseId: Int
    ): Result<List<Exam>>


    @GET("course/result")
    suspend fun getResult(
        @Header("Authorization") token: String = TOKEN,
    ): Result<List<ExamResult>>



    @GET("extra/notice/")
    suspend fun getNotices(
        @Header("Authorization") token: String = TOKEN,
    ): Result<List<Notice>>


    @GET("extra/faq/")
    suspend fun getFaqs(
        @Header("Authorization") token: String = TOKEN,
    ): Result<List<Faq>>

    @GET("extra/pdf/")
    suspend fun getPdfBooks(
        @Header("Authorization") token: String = TOKEN,
    ): Result<List<PdfBook>>

}