package com.example.minipojects.sampleFiles.roomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.minipojects.R
import com.example.minipojects.sampleFiles.roomdb.entities.Director
import com.example.minipojects.sampleFiles.roomdb.entities.School
import com.example.minipojects.sampleFiles.roomdb.entities.Student
import com.example.minipojects.sampleFiles.roomdb.entities.Subject
import com.example.minipojects.sampleFiles.roomdb.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

//make it launcher activity to create an db
class RoomDBAccess : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(context = this).schoolDao

        val schools = listOf(
            School("School1"),
            School("School2"),
            School("School3")
        )

        val students = listOf(
            Student("Dasari",1,"School1"),
            Student("Revathi",2,"School2"),
            Student("Reddy",6,"School3"),
            Student("Sai",7,"School1"),
            Student("Swetha",7,"School1")
        )

        val subjects = listOf(
            Subject("Telugu"),
            Subject("English"),
            Subject("Maths"),
            Subject("Science"),
            Subject("Social")
        )

        val directors = listOf(
            Director("D1","School1"),
            Director("D2","School2"),
            Director("D3","School3")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Dasari","Telugu"),
            StudentSubjectCrossRef("Dasari","Maths"),
            StudentSubjectCrossRef("Dasari","Science"),
            StudentSubjectCrossRef("Revathi","Telugu"),
            StudentSubjectCrossRef("Reddy","Social"),
            StudentSubjectCrossRef("Sai","Telugu"),
            StudentSubjectCrossRef("Sai","Maths"),
            StudentSubjectCrossRef("Sai","English"),
            StudentSubjectCrossRef("Swetha","English")
        )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            students.forEach { dao.insertStudent(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }


            val schoolWithDirector = dao.getSchoolAndDirectorBySchoolName("School1")
            //schoolWithDirector.first().director

            val schoolWithStudents = dao.getSchoolWithStudents("School2")
            //schoolWithStudents.first().students

            val subjectOfStudents = dao.getStudentsOfSubject("Maths")
            val studentWithSubjects = dao.getSubjectsOfStudent("Sai")
        }

    }


}