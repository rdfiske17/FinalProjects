package com.example.cobbersecure
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
    @Update
    suspend fun update(user: User)
    @Delete
    suspend fun delete(user: User)
    @Query("SELECT * FROM user_table WHERE user_id = :key")
    fun get(key: Long): LiveData<User>
    @Query("SELECT * FROM user_table ORDER BY user_id DESC")
    fun getAll(): LiveData<List<User>>
    @Query("SELECT user_id FROM user_table WHERE user_email= :email AND user_password= :password")
    fun loginQuery(email: String, password: String): LiveData<Int>

}