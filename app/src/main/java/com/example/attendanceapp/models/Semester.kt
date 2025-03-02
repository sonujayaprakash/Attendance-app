package com.example.attendanceapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "semester")
data class Semester(@PrimaryKey(autoGenerate = true)
                    val semesterId: Int = 0,
                    @ColumnInfo(name = "semester_name")
                    val semesterName: String)