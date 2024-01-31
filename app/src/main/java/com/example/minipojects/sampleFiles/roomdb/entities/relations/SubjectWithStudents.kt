package com.example.minipojects.sampleFiles.roomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.minipojects.sampleFiles.roomdb.entities.Student
import com.example.minipojects.sampleFiles.roomdb.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject : Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students : List<Student>
)
