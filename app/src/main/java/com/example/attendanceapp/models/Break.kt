package com.example.attendanceapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "break")
data class Break(
    @PrimaryKey(autoGenerate = true)
    val breakId: Int = 0,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "start")
    val start: String,
    @ColumnInfo(name = "end")
    val end: String
)
