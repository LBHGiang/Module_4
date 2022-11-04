package practice.student_management_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.student_management_login.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
