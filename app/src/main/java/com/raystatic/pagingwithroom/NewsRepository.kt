package com.raystatic.pagingwithroom

import android.util.Log
import com.raystatic.pagingwithroom.response.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: ApiService
){

    suspend fun getArticles(page:Int): NewsResponse {
        Log.d("PAGEDEBUG: ", "getArticles: $page")
        return apiService.getHeadlines(country = "in",apiKey = "1199abc09655435b829cac50f16f9265", page = page)
    }

}