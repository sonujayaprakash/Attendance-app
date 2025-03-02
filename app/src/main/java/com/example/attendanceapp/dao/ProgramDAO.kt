package com.example.attendanceapp.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.attendanceapp.models.Program

@Dao
interface ProgramDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProgram(program: Program)
}