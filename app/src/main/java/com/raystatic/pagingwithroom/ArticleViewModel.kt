package com.raystatic.pagingwithroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.raystatic.pagingwithroom.response.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val repository: NewsRepository,
    private val articleDB: ArticleDB
):ViewModel() {

    val dataFlow : Flow<PagingData<Article>>  = Pager(
        config = PagingConfig(
            pageSize = 10,
            maxSize = 30,
            enablePlaceholders = false
        ),
        remoteMediator = ArticleRemoteMediator(
            articleDB,
            repository
        )){
        articleDB.getArticleDao().pagingSource()
    }.flow
        .cachedIn(viewModelScope)

}