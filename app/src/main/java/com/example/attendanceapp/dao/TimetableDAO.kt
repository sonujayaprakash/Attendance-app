package com.example.attendanceapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.attendanceapp.models.Timetable
import com.example.attendanceapp.models.User

@Dao
interface TimetableDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTimetable(timetable: Timetable)
}