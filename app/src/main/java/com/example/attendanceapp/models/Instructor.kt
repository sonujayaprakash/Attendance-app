package com.example.attendanceapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instructor")
data class Instructor(
    @PrimaryKey(autoGenerate = true)
    val instructorId: Int = 0,
    @ColumnInfo(name = "instruct_name")
    val instructorName: String

)