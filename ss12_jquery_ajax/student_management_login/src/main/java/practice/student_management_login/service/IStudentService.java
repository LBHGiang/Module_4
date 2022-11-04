package practice.student_management_login.service;

import practice.student_management_login.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    public List<Student> findAll();

    public Optional<Student> findById(int id);

    public Student save(Student student);

    public void delete(Integer id);

    public void delete(Student student);

}
