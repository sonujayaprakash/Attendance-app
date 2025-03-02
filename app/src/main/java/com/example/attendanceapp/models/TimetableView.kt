package com.example.attendanceapp.models

import androidx.room.DatabaseView
import java.time.Period

@DatabaseView(
    "select timetable.id,"+
            "timetable.day,"+
            "timetable.start,"+
            "timetable.`end`,"+
            "timetable.period,"+
            "subjects.subject_name,"+
            "instructor.instruct_name "+
            "from timetable inner join subjects on "+
            "timetable.subject_id = subjects.subject_id "+
            "inner join instructor on "+
            "instructor.instructorId = "+
            "timetable.instructor_id"


)
data class TimetableView(
    val id :Int,
    val day: String,
    val start: String,
    val end: String,
    val period: String,
    val subject_name: String,
    val instruct_name: String
)
