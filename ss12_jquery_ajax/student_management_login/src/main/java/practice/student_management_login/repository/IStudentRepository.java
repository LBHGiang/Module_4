package practice.student_management_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practice.student_management_login.model.Student;

import javax.transaction.Transactional;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from student where id = :id", nativeQuery = true)
    void deleteStudentById(@Param("id") Integer id);
}
