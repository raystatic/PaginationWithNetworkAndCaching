package com.raystatic.pagingwithroom

import com.raystatic.pagingwithroom.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String,
        @Query("page") page:Int
    ):NewsResponse

    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
    }

}