package com.amirhusseinsoori.data.db.converter

import androidx.room.TypeConverter
import com.amirhusseinsoori.data.db.entity.SourceEntity
import com.amirhusseinsoori.domain.entity.Source


class Converters {

    @TypeConverter
    fun fromSource(source: SourceEntity): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): SourceEntity {
        return SourceEntity(name, name)
    }
}
