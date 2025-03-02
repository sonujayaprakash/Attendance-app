package com.example.attendanceapp.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.attendanceapp.dao.BreakDAO
import com.example.attendanceapp.dao.InstructorDAO
import com.example.attendanceapp.dao.ProgramDAO
import com.example.attendanceapp.dao.SemesterDAO
import com.example.attendanceapp.dao.SubjectsDAO
import com.example.attendanceapp.dao.TimetableDAO
import com.example.attendanceapp.dao.TimetableViewDAO
import com.example.attendanceapp.dao.UserDAO
import com.example.attendanceapp.models.Break
import com.example.attendanceapp.models.Instructor
import com.example.attendanceapp.models.Program
import com.example.attendanceapp.models.Semester
import com.example.attendanceapp.models.Subjects
import com.example.attendanceapp.models.Timetable
import com.example.attendanceapp.models.TimetableView
import com.example.attendanceapp.models.User

@Database(entities = [User::class,Break::class,Instructor::class,Program::class,Semester::class,Subjects::class, Timetable::class ] , views = [TimetableView::class],
    version=1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO():UserDAO
    abstract fun breakDAO():BreakDAO
    abstract fun SemesterDAO():SemesterDAO
    abstract fun instructorDAO():InstructorDAO
    abstract fun subjectsDAO():SubjectsDAO
    abstract fun programDAO():ProgramDAO
    abstract fun timetableDAO():TimetableDAO
    abstract fun timetableViewDAO(): TimetableViewDAO

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase = INSTANCE ?: synchronized(this)
        {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                name = "attendance_db"
            ).fallbackToDestructiveMigration().build()
            INSTANCE = instance
            return instance
        }
    }
}