package com.example.minipojects.sampleFiles.roomdb.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"])//creates an new table with combination of these primary keys
data class StudentSubjectCrossRef(
    val studentName : String,
    val subjectName : String
)
