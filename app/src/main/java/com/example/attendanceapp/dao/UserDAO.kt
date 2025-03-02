package com.example.attendanceapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.attendanceapp.models.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user:User)
    @Delete
    suspend fun deleteUser(user:User)
    @Query("Select * from user")
    suspend fun getUsers():List<User>
    @Query("Select * from user where email = :mailid")
    suspend fun getUserByEmail(mailid: String):User
}