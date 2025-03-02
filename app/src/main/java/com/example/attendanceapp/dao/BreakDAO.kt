package com.example.attendanceapp.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.attendanceapp.models.Break

@Dao
interface BreakDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBreak(interval: Break)

    @Delete
    suspend fun deleteBreak(interval:Break)

    @Query("Select * from break")
    suspend fun getBreak() :List<Break>

    @Query("Select * from break where breakId = :id")
    suspend fun getBreakById(id : Int) : Break
}