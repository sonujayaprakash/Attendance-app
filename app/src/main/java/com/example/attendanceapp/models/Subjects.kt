package com.example.attendanceapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subjects(@PrimaryKey
                    @ColumnInfo(name = "subject_id")
                    val subjectId: String,
                    @ColumnInfo(name = "subject_name")
                    val subjectName: String
)