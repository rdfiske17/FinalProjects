package com.example.cobbersecure
import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "user_table")
data class User(
    @ColumnInfo(name = "user_id")
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "user_password")
    var userPassword: String = "",

    @ColumnInfo(name = "user_fname")
    var userFname: String = "",

    @ColumnInfo(name = "user_lname")
    var userLname: String = "",

    @ColumnInfo(name = "user_email")
    var userEmail: String = "",

    @ColumnInfo(name = "user_bio")
    var userBio: String = "",

    @ColumnInfo(name = "user_img")
    var userImageName: String = "",

    @ColumnInfo(name = "user_friendlist")
    var userFriendList: List<Int>? = null //https://stackoverflow.com/questions/44986626/android-room-database-how-to-handle-arraylist-in-an-entity
)
