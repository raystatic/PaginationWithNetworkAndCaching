package com.raystatic.pagingwithroom

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raystatic.pagingwithroom.response.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles:List<Article>)

    @Query("SELECT * FROM articles")
    fun pagingSource():PagingSource<Int,Article>

    @Query("DELETE FROM articles")
    suspend fun deleteAll()

}