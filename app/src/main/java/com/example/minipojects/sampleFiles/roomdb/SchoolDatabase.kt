package com.example.minipojects.sampleFiles.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.minipojects.sampleFiles.roomdb.entities.Director
import com.example.minipojects.sampleFiles.roomdb.entities.School
import com.example.minipojects.sampleFiles.roomdb.entities.Student
import com.example.minipojects.sampleFiles.roomdb.entities.Subject
import com.example.minipojects.sampleFiles.roomdb.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao : SchoolDao

    companion object {
        @Volatile //to update the accessing method on change
        private var INSTANCE : SchoolDatabase? = null

        fun getInstance(context : Context) : SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }



    }
}
