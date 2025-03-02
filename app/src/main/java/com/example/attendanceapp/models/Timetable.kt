package com.example.attendanceapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (tableName = "timetable",
    foreignKeys = [
        ForeignKey(
            entity = Break::class,
            parentColumns = ["breakId"],
            childColumns = ["break_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Instructor::class,
            parentColumns = ["instructorId"],
            childColumns = ["instructor_id"]
        ),
        ForeignKey(
            entity = Program::class,
            parentColumns = ["program_id"],
            childColumns = ["program_id"]
        ),
        ForeignKey(
            entity = Semester::class,
            parentColumns = ["semesterId"],
            childColumns = ["sem_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Subjects::class,
            parentColumns = ["subject_id"],
            childColumns = ["subject_id"]
        )
    ]
)
data class Timetable(@PrimaryKey(autoGenerate = true)
                     val id: Int = 0,
                     @ColumnInfo(name = "day")
                     val day:String,
                     @ColumnInfo(name = "start")
                     val start: String,
                     @ColumnInfo(name = "end")
                     val end: String?,
                     @ColumnInfo (name = "period")
                     val period: Int,
                     @ColumnInfo(name = "sem_id")
                     val semId: String,
                     @ColumnInfo(name = "break_id")
                     val breakId: String,
                     @ColumnInfo(name = "program_id")
                     val programId: String,
                     @ColumnInfo(name = "instructor_id")
                     val instructorId: String,
                     @ColumnInfo(name = "subject_id")
                     val subjectId: String="Student"
)