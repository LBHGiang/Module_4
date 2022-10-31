package practice.student_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.student_management.dto.StudentDto;
import practice.student_management.model.Student;
import practice.student_management.service.IStudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RestStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> list() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity save(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@RequestBody StudentDto studentDto, @PathVariable Long id) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Student student = optionalStudent.get();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);
    }
}
