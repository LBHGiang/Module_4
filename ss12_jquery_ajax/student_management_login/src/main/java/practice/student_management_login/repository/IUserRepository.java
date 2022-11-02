package practice.student_management_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.student_management_login.model.User;

public interface ILoginRepository extends JpaRepository<User, Integer> {
}
