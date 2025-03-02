package com.example.attendanceapp.dao

import androidx.room.Dao


import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.attendanceapp.models.Semester
@Dao
interface SemesterDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSemester(semester: Semester)
}