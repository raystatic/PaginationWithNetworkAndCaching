package com.raystatic.pagingwithroom

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raystatic.pagingwithroom.response.Article

@Database(
    entities = [Article::class, RemoteKey::class],
    version = 1
)
abstract class ArticleDB: RoomDatabase() {

    abstract fun getArticleDao():ArticleDao
    abstract fun getRemoteKeyDao():RemoteKeysDao

}