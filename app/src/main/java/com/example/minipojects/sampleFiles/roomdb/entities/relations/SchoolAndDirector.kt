package com.example.minipojects.sampleFiles.roomdb.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.minipojects.sampleFiles.roomdb.entities.Director
import com.example.minipojects.sampleFiles.roomdb.entities.School

//1 to 1 entity relationship from school to director
data class SchoolAndDirector(

    @Embedded val school : School,//embedded means including school table
    @Relation(
        parentColumn = "schoolName",// schoolName key from School table
        entityColumn = "schoolName"//schoolName key from Director table
    )
    val director: Director
)