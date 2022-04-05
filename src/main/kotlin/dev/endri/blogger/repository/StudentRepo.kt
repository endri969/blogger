package dev.endri.blogger.repository

import dev.endri.blogger.exceptions.NotFoundException
import dev.endri.blogger.model.Student
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class StudentRepo {

    private val logger = LoggerFactory.getLogger(javaClass)

    final var students = mutableListOf<Student>()

    init{
        val s1 = Student("Hari",24,"Student Address 1")
        val s2 = Student("Sandy",33,"Student Address 2")
        val s3 = Student("Jenny",12,"Student Address 3")

        students.add(s1)
        students.add(s2)
        students.add(s3)
    }

    fun getStudent(id: Int): Student {
        this.checkValidIndex(id)
        return students[id]
    }

    fun getAllStudents(): List<Student> {
        return students.toList()
    }

    fun addStudent(student: Student){
        students.add(student)
    }

    fun updateStudent(id: Int, student: Student) {
        this.checkValidIndex(id)
        students.add(id,student)
    }

    private fun checkValidIndex(id: Int){
        try {
            students[id]
        } catch (ex: Exception){
            logger.info("Student with id $id not found.")
            throw NotFoundException("Student with id $id not found.")
        }
    }
}