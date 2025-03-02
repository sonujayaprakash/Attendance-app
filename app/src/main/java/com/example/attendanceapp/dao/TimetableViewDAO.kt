package com.example.attendanceapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.attendanceapp.models.TimetableView

@Dao
interface TimetableViewDAO {
    @Query("Select * from timetableView where day = :day")
    suspend fun getTimetableByDay(day:String):List<TimetableView>
}