package com.example.attendanceapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "program")
data class Program(
    @PrimaryKey
    @ColumnInfo(name = "program_id")
    val programId: String,
    @ColumnInfo(name = "program_name")
    val programName: String,
    @ColumnInfo(name = "semester")
    val semester: String)