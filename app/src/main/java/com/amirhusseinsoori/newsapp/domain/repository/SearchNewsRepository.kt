package com.amirhusseinsoori.newsapp.domain.repository

import androidx.paging.PagingData
import com.amirhusseinsoori.newsapp.presentation.entity.Article

import kotlinx.coroutines.flow.Flow

interface SearchNewsRepository {

    suspend fun searchArticlesNews(Search: String): Flow<PagingData<Article>>
}