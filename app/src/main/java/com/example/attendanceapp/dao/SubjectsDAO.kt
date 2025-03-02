package com.example.attendanceapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.attendanceapp.models.Subjects
@Dao
interface SubjectsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubjects(subjects: Subjects)
}