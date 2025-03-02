package com.example.attendanceapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.attendanceapp.models.Instructor
import com.example.attendanceapp.models.User
@Dao
interface InstructorDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInstructor(instructor: Instructor)

    @Delete
    suspend fun deleteUser(instructor: Instructor)

//    @Query("Select * from instructor")
//    suspend fun getUser() : List<User>

}