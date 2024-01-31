package com.example.minipojects.sampleFiles.roomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.minipojects.sampleFiles.roomdb.entities.School
import com.example.minipojects.sampleFiles.roomdb.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
