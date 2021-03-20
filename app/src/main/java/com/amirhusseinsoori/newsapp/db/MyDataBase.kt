package com.amirhusseinsoori.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amirhusseinsoori.newsapp.db.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MyDataBase: RoomDatabase() {


    abstract fun getArticleDao(): ArticleDao
}