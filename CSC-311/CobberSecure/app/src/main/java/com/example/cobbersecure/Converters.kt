package com.example.cobbersecure
import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// Courtesy of https://stackoverflow.com/a/64775101
class Converters {
    @TypeConverter
    fun fromList(value : List<Int>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<Int>>(value)
}