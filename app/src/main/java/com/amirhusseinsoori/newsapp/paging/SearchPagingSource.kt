package com.amirhusseinsoori.newsapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amirhusseinsoori.newsapp.api.NewsAPI
import com.amirhusseinsoori.newsapp.api.response.Article
import com.amirhusseinsoori.newsapp.util.Constants.Companion.PAGING_START_PAGE
import com.bumptech.glide.load.HttpException
import java.io.IOException

class SearchPagingSource(
    private val api: NewsAPI,
    private val query: String
): PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>) = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: PAGING_START_PAGE
        return try {
            val response = api.searchForNews(query ,position ,params.loadSize)
            val article = response.articles

            LoadResult.Page(
                data = article,
                prevKey = if (position == PAGING_START_PAGE) null else position - 1,
                nextKey = if (article.isEmpty()) null else position + 1
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}