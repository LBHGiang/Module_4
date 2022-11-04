package practice.student_management_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.student_management_login.model.User;
import practice.student_management_login.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}
