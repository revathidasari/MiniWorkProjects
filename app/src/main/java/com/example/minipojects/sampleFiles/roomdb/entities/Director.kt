package com.example.minipojects.sampleFiles.roomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity//(tableName = "director_table") for renaming the table
data class Director(
    @PrimaryKey(autoGenerate = false)
    val directorName : String,
    val schoolName : String
)
