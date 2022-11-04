package practice.student_management_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.student_management_login.model.Student;
import practice.student_management_login.repository.IStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
         studentRepository.deleteStudentById(id);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
