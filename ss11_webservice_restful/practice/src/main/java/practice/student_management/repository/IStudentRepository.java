package practice.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practice.student_management.model.Student;

import javax.transaction.Transactional;


public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from student where id = :id", nativeQuery = true)
    void deleteStudentById(@Param("id") Long id);

}
