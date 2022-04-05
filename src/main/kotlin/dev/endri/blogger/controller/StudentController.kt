package dev.endri.blogger.controller

import dev.endri.blogger.model.Student
import dev.endri.blogger.repository.StudentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class StudentController {

    @Autowired
    val studentRepo = StudentRepo()

    @GetMapping("/students")
    fun getAllStudents(): List<Student>{
        return studentRepo.getAllStudents()
    }

    @GetMapping("/students/{id}")
    fun getStudent(@PathVariable id:Int): Student{
        return studentRepo.getStudent(id)
    }

    @PostMapping("/student")
    fun createStudent(@RequestBody student: Student) : ResponseEntity<Unit> {

        studentRepo.addStudent(student)

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/student/{id}")
    fun updateStudent(@PathVariable id: Int, @RequestBody student: Student) : ResponseEntity<Unit> {
        studentRepo.updateStudent(id, student)
        return ResponseEntity.ok().build()
    }

}