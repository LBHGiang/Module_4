package practice.student_management_login.service;

import practice.student_management_login.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    Optional<User> findById(Integer id);

}
