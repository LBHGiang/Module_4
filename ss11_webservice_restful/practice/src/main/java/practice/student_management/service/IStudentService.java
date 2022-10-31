package practice.student_management.service;

import practice.student_management.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> findAll();

    void save(Student student);

    Optional<Student> findById(Long id);

    void update(Student student);

    void remove(Long id);
}
